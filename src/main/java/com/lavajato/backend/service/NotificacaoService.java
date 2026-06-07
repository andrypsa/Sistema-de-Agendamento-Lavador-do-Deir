package com.lavajato.backend.service;

import java.util.List;

import com.lavajato.backend.model.Notificacao;
import com.lavajato.backend.repository.NotificacaoRepository;

public class NotificacaoService {

    private final NotificacaoRepository repository = new NotificacaoRepository();

    public List<Notificacao> listar() {
        return repository.listar();
    }

    public void cadastrar(Notificacao notificacao) {

        List<Notificacao> notificacoes = repository.listar();

        long novoId = 1;

        if (!notificacoes.isEmpty()) {
            novoId = notificacoes.get(notificacoes.size() - 1).getId() + 1;
        }

        notificacao.setId(novoId);

        notificacoes.add(notificacao);

        repository.salvar(notificacoes);
    }

    public void salvar(List<Notificacao> notificacoes) {
        repository.salvar(notificacoes);
    }

}