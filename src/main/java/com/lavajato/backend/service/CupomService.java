package com.lavajato.backend.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import com.lavajato.backend.model.Cupom;
import com.lavajato.backend.repository.CupomRepository;

public class CupomService {

    private final CupomRepository repository = new CupomRepository();

    // Lista todos os cupons salvos no arquivo JSON
    public List<Cupom> listar() {
        return repository.listar();
    }

    // Cadastra um novo cupom no sistema
    public void cadastrar(Cupom cupom) {

        List<Cupom> cupons = repository.listar();

        long novoId = 1;

        // Gera um novo ID com base no último cupom salvo
        if (!cupons.isEmpty()) {
            novoId = cupons.get(cupons.size() - 1).getId() + 1;
        }

        cupom.setId(novoId);

        // Caso o cupom ainda não tenha código, gera um automaticamente
        if (cupom.getCodigo() == null || cupom.getCodigo().isBlank()) {
            cupom.setCodigo(gerarCodigo());
        }

        // Define a data de geração e validade do cupom, com prazo de 30 dias
        if (cupom.getDataGeracao() == null || cupom.getDataGeracao().isBlank()) {
            LocalDate hoje = LocalDate.now();
            cupom.setDataGeracao(hoje.toString());
            cupom.setDataValidade(hoje.plusDays(30).toString());
        }

        // Todo cupom novo começa como não utilizado
        cupom.setUtilizado(false);

        cupons.add(cupom);

        // Salva a lista atualizada de cupons no arquivo JSON
        repository.salvar(cupons);
    }

    // Gera um código aleatório de 8 caracteres para o cupom
    public String gerarCodigo() {

        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();

        StringBuilder codigo = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            codigo.append(caracteres.charAt(random.nextInt(caracteres.length())));
        }

        return codigo.toString();
    }

    // Gera um cupom de fidelidade para o cliente que completou 10 lavadas
    public void gerarCupomFidelidade(Long clienteId) {

        Cupom cupom = new Cupom();

        cupom.setClienteId(clienteId);
        cupom.setDesconto(25);
        cupom.setCodigo(gerarCodigo());
        cupom.setUtilizado(false);

        cadastrar(cupom);
    }

    // Marca um cupom como utilizado pelo administrador
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