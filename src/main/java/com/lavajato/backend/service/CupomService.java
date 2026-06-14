package com.lavajato.backend.service;

import java.time.LocalDate;
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

        if (cupom.getDataGeracao() == null || cupom.getDataGeracao().isBlank()) {
            LocalDate hoje = LocalDate.now();
            cupom.setDataGeracao(hoje.toString());
            cupom.setDataValidade(hoje.plusDays(30).toString());
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

    public void gerarCupomFidelidade(Long clienteId) {

        Cupom cupom = new Cupom();

        cupom.setClienteId(clienteId);
        cupom.setDesconto(25);
        cupom.setCodigo(gerarCodigo());
        cupom.setUtilizado(false);

        cadastrar(cupom);
    }

    public boolean marcarComoUtilizado(Long id) {

        List<Cupom> cupons = repository.listar();

        for (Cupom cupom : cupons) {

            if (cupom.getId().equals(id)) {

                cupom.setUtilizado(true);

                repository.salvar(cupons);

                return true;
            }
        }

        return false;
    }
}