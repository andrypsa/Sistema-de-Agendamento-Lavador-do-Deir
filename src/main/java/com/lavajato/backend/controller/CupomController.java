package com.lavajato.backend.controller;

import com.lavajato.backend.model.Cupom;
import com.lavajato.backend.service.CupomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cupons")
@CrossOrigin("*")
public class CupomController {

    private final CupomService service = new CupomService();

    @GetMapping
    public List<Cupom> listar() {
        return service.listar();
    }

    @PostMapping
    public String cadastrar(@RequestBody Cupom cupom) {

        service.cadastrar(cupom);

        return "Cupom cadastrado com sucesso!";
    }
}