package com.lavajato.backend.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lavajato.backend.model.Agendamento;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoRepository {

    private static final String CAMINHO = "dados/agendamentos.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    // Lê o arquivo JSON e retorna a lista de agendamentos
    public List<Agendamento> listar() {

        File arquivo = new File(CAMINHO);

        // Se o arquivo ainda não existir, retorna uma lista vazia
        if (!arquivo.exists()) {
            return new ArrayList<>();
        }

        try {
            return objectMapper.readValue(
                    arquivo,
                    new TypeReference<List<Agendamento>>() {
                    });
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    // Salva a lista de agendamentos no arquivo JSON
    public void salvar(List<Agendamento> agendamentos) {

        try {
            objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File(CAMINHO), agendamentos);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}