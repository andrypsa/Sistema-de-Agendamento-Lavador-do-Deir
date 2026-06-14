package com.lavajato.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lavajato.backend.model.Cupom;
import com.lavajato.backend.service.CupomService;

@RestController
@RequestMapping("/cupons")
@CrossOrigin("*")
public class CupomController {

    private final CupomService service = new CupomService();

    // Retorna todos os cupons cadastrados
    @GetMapping
    public List<Cupom> listar() {
        return service.listar();
    }

    // Cadastra um novo cupom no sistema
    @PostMapping
    public String cadastrar(@RequestBody Cupom cupom) {

        service.cadastrar(cupom);

        return "Cupom cadastrado com sucesso!";
    }

    // Marca um cupom como utilizado
    @PutMapping("/{id}/utilizar")
    public String marcarComoUtilizado(@PathVariable Long id) {

        boolean atualizado = service.marcarComoUtilizado(id);

        if (atualizado) {
            return "Cupom marcado como utilizado.";
        }

        return "Cupom não encontrado.";
    }
}