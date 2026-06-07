package com.lavajato.backend.service;

import java.util.List;
import java.util.Random;

import com.lavajato.backend.model.Cupom;
import com.lavajato.backend.repository.CupomRepository;

public class CupomService {

    private final CupomRepository repository = new CupomRepository();

    public List<Cupom> listar() {
        return repository.listar();
    }

    public void cadastrar(Cupom cupom) {

        List<Cupom> cupons = repository.listar();

        long novoId = 1;

        if (!cupons.isEmpty()) {
            novoId = cupons.get(cupons.size() - 1).getId() + 1;
        }

        cupom.setId(novoId);

        if (cupom.getCodigo() == null || cupom.getCodigo().isBlank()) {
            cupom.setCodigo(gerarCodigo());
        }

        cupom.setUtilizado(false);

        cupons.add(cupom);

        repository.salvar(cupons);
    }

    public String gerarCodigo() {

        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();

        StringBuilder codigo = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            codigo.append(caracteres.charAt(random.nextInt(caracteres.length())));
        }

        return codigo.toString();
    }

}