package com.lavajato.backend.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lavajato.backend.model.Cupom;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CupomRepository {

    private static final String CAMINHO = "dados/cupons.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    // Lê o arquivo JSON e retorna a lista de cupons
    public List<Cupom> listar() {

        File arquivo = new File(CAMINHO);

        // Se o arquivo ainda não existir, retorna uma lista vazia
        if (!arquivo.exists()) {
            return new ArrayList<>();
        }

        try {
            return objectMapper.readValue(
                    arquivo,
                    new TypeReference<List<Cupom>>() {
                    });
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    // Salva a lista de cupons no arquivo JSON
    public void salvar(List<Cupom> cupons) {

        try {
            objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File(CAMINHO), cupons);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}