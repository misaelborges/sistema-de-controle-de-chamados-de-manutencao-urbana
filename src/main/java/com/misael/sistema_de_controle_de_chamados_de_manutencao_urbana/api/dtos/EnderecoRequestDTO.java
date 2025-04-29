package com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.api.dtos;

import jakarta.validation.constraints.NotBlank;

public class EnderecoRequestDTO {

    @NotBlank(message = "O campo rua não pode ser em branco")
    private String rua;

    @NotBlank(message = "O campo numero não pode ser em branco")
    private String numero;

    @NotBlank(message = "O campo bairro não pode ser em branco")
    private String bairro;

    @NotBlank(message = "O campo cidade não pode ser em branco")
    private String cidade;

    public EnderecoRequestDTO() {
    }

    public EnderecoRequestDTO(String rua, String numero, String bairro, String cidade) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
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
