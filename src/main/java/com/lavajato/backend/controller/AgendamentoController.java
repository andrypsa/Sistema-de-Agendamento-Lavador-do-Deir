package com.lavajato.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping
    public List<Agendamento> listar() {
        return service.listar();
    }

    @PostMapping
    public String cadastrar(@RequestBody Agendamento agendamento) {

        service.cadastrar(agendamento);

        return "Agendamento realizado com sucesso!";
    }
}