package com.lavajato.backend.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lavajato.backend.model.Notificacao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NotificacaoRepository {

    private static final String CAMINHO = "dados/notificacoes.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    // Lê o arquivo JSON e retorna a lista de notificações
    public List<Notificacao> listar() {

        File arquivo = new File(CAMINHO);

        // Se o arquivo ainda não existir, retorna uma lista vazia
        if (!arquivo.exists()) {
            return new ArrayList<>();
        }

        try {
            return objectMapper.readValue(
                    arquivo,
                    new TypeReference<List<Notificacao>>() {
                    });
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    // Salva a lista de notificações no arquivo JSON
    public void salvar(List<Notificacao> notificacoes) {

        try {
            objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File(CAMINHO), notificacoes);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}