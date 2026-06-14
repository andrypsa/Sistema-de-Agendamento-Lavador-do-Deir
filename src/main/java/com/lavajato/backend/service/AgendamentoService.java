package com.lavajato.backend.service;

import java.util.List;

import com.lavajato.backend.model.Agendamento;
import com.lavajato.backend.repository.AgendamentoRepository;
import com.lavajato.backend.service.ClienteService;
import com.lavajato.backend.service.CupomService;
public class AgendamentoService {

    private final AgendamentoRepository repository = new AgendamentoRepository();
    private final ClienteService clienteService = new ClienteService();
    private final CupomService cupomService = new CupomService();

    public List<Agendamento> listar() {
        return repository.listar();
    }

    public void cadastrar(Agendamento agendamento) {

        List<Agendamento> agendamentos = repository.listar();

        for (Agendamento existente : agendamentos) {

            boolean mesmaData = existente.getData().equals(agendamento.getData());
            boolean mesmoHorario = existente.getHoraInicio().equals(agendamento.getHoraInicio());

            boolean statusBloqueiaHorario = existente.getStatus().equals("PENDENTE")
                    || existente.getStatus().equals("APROVADO");

            if (mesmaData && mesmoHorario && statusBloqueiaHorario) {
                throw new RuntimeException(
                        "Já existe uma solicitação de agendamento para esta data e horário. Por favor, escolha outro horário disponível.");
            }
        }

        long novoId = 1;

        if (!agendamentos.isEmpty()) {
            novoId = agendamentos.get(agendamentos.size() - 1).getId() + 1;
        }

        agendamento.setId(novoId);

        agendamentos.add(agendamento);

        repository.salvar(agendamentos);
    }

    public Agendamento buscarPorId(Long id) {

        List<Agendamento> agendamentos = repository.listar();

        for (Agendamento agendamento : agendamentos) {

            if (agendamento.getId().equals(id)) {
                return agendamento;
            }
        }

        return null;
    }

    public boolean atualizarDecisao(Long id, String status, String justificativa) {

        List<Agendamento> agendamentos = repository.listar();

        for (Agendamento agendamento : agendamentos) {

            if (agendamento.getId().equals(id)) {

                agendamento.setStatus(status);
                agendamento.setJustificativa(justificativa);

                repository.salvar(agendamentos);

                return true;
            }
        }

        return false;
    }

    public String concluirAgendamento(Long id) {

        List<Agendamento> agendamentos = repository.listar();

        for (Agendamento agendamento : agendamentos) {

            if (agendamento.getId().equals(id)) {

                if ("CONCLUIDO".equals(agendamento.getStatus())) {
                    return "Este agendamento já foi concluído.";
                }

                if (!"APROVADO".equals(agendamento.getStatus())) {
                    return "Apenas agendamentos aceitos podem ser concluídos.";
                }

                agendamento.setStatus("CONCLUIDO");
                repository.salvar(agendamentos);

                boolean gerouCupom = clienteService.registrarLavadaConcluida(agendamento.getClienteId());

                if (gerouCupom) {
                    cupomService.gerarCupomFidelidade(agendamento.getClienteId());
                    return "Agendamento concluído com sucesso! O cliente completou 10 lavadas e ganhou um cupom de 25%.";
                }

                return "Agendamento concluído com sucesso!";
            }
        }

        return "Agendamento não encontrado.";
    }
}