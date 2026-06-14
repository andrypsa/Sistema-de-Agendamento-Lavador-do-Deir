package com.lavajato.backend.model;

// Representa o cliente cadastrado no sistema
public class Cliente {

    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private String senha;

    // Controla a quantidade de lavadas concluídas para o programa de fidelidade
    private int quantidadeLavadas;

    public Cliente() {
    }

    public Cliente(Long id, String nome, String telefone, String email, String senha, int quantidadeLavadas) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.quantidadeLavadas = quantidadeLavadas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getQuantidadeLavadas() {
        return quantidadeLavadas;
    }

    public void setQuantidadeLavadas(int quantidadeLavadas) {
        this.quantidadeLavadas = quantidadeLavadas;
    }
}