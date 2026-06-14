package com.lavajato.backend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lavajato.backend.model.Agendamento;
import com.lavajato.backend.service.AgendamentoService;

@RestController
@RequestMapping("/agendamentos")
@CrossOrigin("*")
public class AgendamentoController {

    private final AgendamentoService service = new AgendamentoService();

    // Retorna todos os agendamentos cadastrados
    @GetMapping
    public List<Agendamento> listar() {
        return service.listar();
    }

    // Recebe uma nova solicitação de agendamento
    @PostMapping
    public String cadastrar(@RequestBody Agendamento agendamento) {

        try {
            service.cadastrar(agendamento);
            return "Agendamento realizado com sucesso!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    // Atualiza a decisão do administrador, aprovando ou recusando o agendamento
    @PutMapping("/{id}/decisao")
    public String atualizarDecisao(@PathVariable Long id, @RequestBody Map<String, String> dados) {

        String status = dados.get("status");
        String justificativa = dados.get("justificativa");

        boolean atualizado = service.atualizarDecisao(id, status, justificativa);

        if (atualizado) {
            return "Decisão salva com sucesso!";
        }

        return "Agendamento não encontrado.";
    }

    // Marca um agendamento aprovado como concluído
    @PutMapping("/{id}/concluir")
    public String concluirAgendamento(@PathVariable Long id) {
        return service.concluirAgendamento(id);
    }
}