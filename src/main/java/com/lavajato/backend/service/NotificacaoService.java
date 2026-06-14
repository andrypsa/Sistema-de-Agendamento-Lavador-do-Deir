package com.lavajato.backend.service;

import java.util.List;

import com.lavajato.backend.model.Notificacao;
import com.lavajato.backend.repository.NotificacaoRepository;

public class NotificacaoService {

    private final NotificacaoRepository repository = new NotificacaoRepository();

    // Lista todas as notificações salvas no arquivo JSON
    public List<Notificacao> listar() {
        return repository.listar();
    }

    // Cadastra uma nova notificação no sistema
    public void cadastrar(Notificacao notificacao) {

        List<Notificacao> notificacoes = repository.listar();

        long novoId = 1;

        // Gera um novo ID com base na última notificação salva
        if (!notificacoes.isEmpty()) {
            novoId = notificacoes.get(notificacoes.size() - 1).getId() + 1;
        }

        notificacao.setId(novoId);

        notificacoes.add(notificacao);

        // Salva a lista atualizada de notificações no arquivo JSON
        repository.salvar(notificacoes);
    }

    // Salva diretamente uma lista de notificações
    public void salvar(List<Notificacao> notificacoes) {
        repository.salvar(notificacoes);
    }

}