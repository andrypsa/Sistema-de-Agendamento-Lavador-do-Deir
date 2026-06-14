package com.lavajato.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lavajato.backend.model.Notificacao;
import com.lavajato.backend.service.NotificacaoService;

@RestController
@RequestMapping("/notificacoes")
@CrossOrigin("*")
public class NotificacaoController {

    private final NotificacaoService service = new NotificacaoService();

    // Retorna todas as notificações cadastradas
    @GetMapping
    public List<Notificacao> listar() {
        return service.listar();
    }

    // Cadastra uma nova notificação no sistema
    @PostMapping
    public String cadastrar(@RequestBody Notificacao notificacao) {

        service.cadastrar(notificacao);

        return "Notificação cadastrada com sucesso!";
    }
}
