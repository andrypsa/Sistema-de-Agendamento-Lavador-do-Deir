package com.lavajato.backend.service;

import java.util.List;

import com.lavajato.backend.model.Cliente;
import com.lavajato.backend.repository.ClienteRepository;

public class ClienteService {

    private final ClienteRepository repository = new ClienteRepository();

    public List<Cliente> listar() {
        return repository.listar();
    }

    public void cadastrar(Cliente cliente) {

        List<Cliente> clientes = repository.listar();

        // Verifica se já existe e-mail cadastrado
        for (Cliente c : clientes) {
            if (c.getEmail().equalsIgnoreCase(cliente.getEmail())) {
                throw new RuntimeException("E-mail já cadastrado.");
            }
        }

        // Gera um ID automaticamente
        long novoId = 1;

        if (!clientes.isEmpty()) {
            novoId = clientes.get(clientes.size() - 1).getId() + 1;
        }

        cliente.setId(novoId);
        cliente.setQuantidadeLavadas(0);

        clientes.add(cliente);

        repository.salvar(clientes);
    }

    public Cliente login(String email, String senha) {

        List<Cliente> clientes = repository.listar();

        for (Cliente cliente : clientes) {

            if (cliente.getEmail().equalsIgnoreCase(email)
                    && cliente.getSenha().equals(senha)) {

                return cliente;
            }
        }

        return null;
    }

    public Cliente buscarPorEmail(String email) {

        List<Cliente> clientes = repository.listar();

        for (Cliente cliente : clientes) {

            if (cliente.getEmail().equalsIgnoreCase(email)) {
                return cliente;
            }
        }

        return null;
    }

    public boolean registrarLavadaConcluida(Long clienteId) {

        List<Cliente> clientes = repository.listar();

        for (Cliente cliente : clientes) {

            if (cliente.getId().equals(clienteId)) {

                int novaQuantidade = cliente.getQuantidadeLavadas() + 1;

                if (novaQuantidade >= 10) {
                    cliente.setQuantidadeLavadas(0);
                    repository.salvar(clientes);
                    return true;
                }

                cliente.setQuantidadeLavadas(novaQuantidade);
                repository.salvar(clientes);

                return false;
            }
        }

        throw new RuntimeException("Cliente não encontrado.");
    }
}