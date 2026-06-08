package com.lavajato.backend.controller;

import com.lavajato.backend.model.Notificacao;
import com.lavajato.backend.service.NotificacaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificacoes")
@CrossOrigin("*")
public class NotificacaoController {

    private final NotificacaoService service = new NotificacaoService();

    @GetMapping
    public List<Notificacao> listar() {
        return service.listar();
    }

    @PostMapping
    public String cadastrar(@RequestBody Notificacao notificacao) {

        service.cadastrar(notificacao);

        return "Notificação cadastrada com sucesso!";
    }
}