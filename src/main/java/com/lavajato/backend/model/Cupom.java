package com.lavajato.backend.model;

public class Cupom {

    private Long id;
    private String codigo;
    private Long clienteId;
    private int desconto;
    private boolean utilizado;

    public Cupom() {
    }

    public Cupom(Long id, String codigo, Long clienteId, int desconto, boolean utilizado) {
        this.id = id;
        this.codigo = codigo;
        this.clienteId = clienteId;
        this.desconto = desconto;
        this.utilizado = utilizado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public int getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }

    public boolean isUtilizado() {
        return utilizado;
    }

    public void setUtilizado(boolean utilizado) {
        this.utilizado = utilizado;
    }
}