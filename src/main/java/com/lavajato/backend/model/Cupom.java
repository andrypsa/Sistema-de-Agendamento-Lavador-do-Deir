package com.lavajato.backend.model;

public class Cupom {

    private Long id;
    private String codigo;
    private Long clienteId;
    private int desconto;
    private boolean utilizado;
    private String dataGeracao;
    private String dataValidade;

    public Cupom() {
    }

    public Cupom(Long id, String codigo, Long clienteId, int desconto, boolean utilizado,
                 String dataGeracao, String dataValidade) {
        this.id = id;
        this.codigo = codigo;
        this.clienteId = clienteId;
        this.desconto = desconto;
        this.utilizado = utilizado;
        this.dataGeracao = dataGeracao;
        this.dataValidade = dataValidade;
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

    public String getDataGeracao() {
        return dataGeracao;
    }

    public void setDataGeracao(String dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }
}