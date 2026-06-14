package com.lavajato.backend.model;

// Representa uma notificação enviada ao cliente
public class Notificacao {

    private Long id;
    private Long clienteId;
    private String mensagem;

    // Indica se a notificação já foi visualizada pelo cliente
    private boolean visualizada;

    public Notificacao() {
    }

    public Notificacao(Long id, Long clienteId, String mensagem, boolean visualizada) {
        this.id = id;
        this.clienteId = clienteId;
        this.mensagem = mensagem;
        this.visualizada = visualizada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public boolean isVisualizada() {
        return visualizada;
    }

    public void setVisualizada(boolean visualizada) {
        this.visualizada = visualizada;
    }
}