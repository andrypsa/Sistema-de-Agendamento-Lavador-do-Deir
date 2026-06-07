package com.lavajato.backend.service;

import java.util.List;

import com.lavajato.backend.model.Agendamento;
import com.lavajato.backend.repository.AgendamentoRepository;

public class AgendamentoService {

    private final AgendamentoRepository repository = new AgendamentoRepository();

    public List<Agendamento> listar() {
        return repository.listar();
    }

    public void cadastrar(Agendamento agendamento) {

        List<Agendamento> agendamentos = repository.listar();

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

}