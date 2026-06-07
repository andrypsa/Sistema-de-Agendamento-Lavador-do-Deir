package com.lavajato.backend.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lavajato.backend.model.Cliente;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {

    private static final String CAMINHO = "dados/clientes.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Cliente> listar() {

        File arquivo = new File(CAMINHO);

        if (!arquivo.exists()) {
            return new ArrayList<>();
        }

        try {
            return objectMapper.readValue(
                    arquivo,
                    new TypeReference<List<Cliente>>() {
                    });
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public void salvar(List<Cliente> clientes) {

        try {
            objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File(CAMINHO), clientes);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}