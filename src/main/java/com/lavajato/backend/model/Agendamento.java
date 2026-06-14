package com.lavajato.backend.model;

// Representa uma solicitação de agendamento feita por um cliente
public class Agendamento {

    private Long id;
    private Long clienteId;
    private String tipoVeiculo;
    private String marca;
    private String modelo;
    private String nivelSujeira;
    private String data;
    private String horaInicio;

    // Status do agendamento: PENDENTE, APROVADO, RECUSADO ou CONCLUIDO
    private String status;

    private String observacao;

    // Justificativa informada pelo administrador em caso de recusa
    private String justificativa;

    public Agendamento() {
    }

    public Agendamento(Long id, Long clienteId, String tipoVeiculo, String marca,
            String modelo, String nivelSujeira, String data, String horaInicio,
            String status, String observacao, String justificativa) {

        this.id = id;
        this.clienteId = clienteId;
        this.tipoVeiculo = tipoVeiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.nivelSujeira = nivelSujeira;
        this.data = data;
        this.horaInicio = horaInicio;
        this.status = status;
        this.observacao = observacao;
        this.justificativa = justificativa;
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

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNivelSujeira() {
        return nivelSujeira;
    }

    public void setNivelSujeira(String nivelSujeira) {
        this.nivelSujeira = nivelSujeira;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }
}