package com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.api.dtos;

import com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.models.Chamado;

public class EnderecoResponseDTO {

    private String rua;
    private String numero;
    private String bairro;
    private String cidade;

    public EnderecoResponseDTO() {
    }

    public EnderecoResponseDTO(Chamado chamado) {
        this.rua = chamado.getEndereco().getRua();
        this.numero = chamado.getEndereco().getNumero();
        this.bairro = chamado.getEndereco().getBairro();
        this.cidade = chamado.getEndereco().getCidade();
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}

