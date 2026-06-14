package com.lavajato.backend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lavajato.backend.model.Cliente;
import com.lavajato.backend.service.ClienteService;

@RestController
@RequestMapping("/clientes")
@CrossOrigin("*")
public class ClienteController {

    private final ClienteService service = new ClienteService();

    // Retorna todos os clientes cadastrados
    @GetMapping
    public List<Cliente> listar() {
        return service.listar();
    }

    // Recebe os dados do formulário e cadastra um novo cliente
    @PostMapping("/cadastrar")
    public String cadastrar(@RequestBody Map<String, String> dados) {

        try {
            Cliente cliente = new Cliente();

            // Preenche o objeto Cliente com os dados recebidos do frontend
            cliente.setNome(dados.get("nome"));
            cliente.setTelefone(dados.get("telefone"));
            cliente.setEmail(dados.get("email"));
            cliente.setSenha(dados.get("senha"));

            service.cadastrar(cliente);

            return "Cliente cadastrado com sucesso!";

        } catch (Exception e) {
            return e.getMessage();
        }
    }

    // Realiza o login do cliente a partir do e-mail e senha informados
    @PostMapping("/login")
    public Cliente login(@RequestBody Map<String, String> dados) {

        String email = dados.get("email");
        String senha = dados.get("senha");

        return service.login(email, senha);
    }
}