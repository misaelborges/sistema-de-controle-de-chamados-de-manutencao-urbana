package com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.models;

import com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.api.dtos.ChamadoRequestDTO;
import com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.api.dtos.EnderecoRequestDTO;
import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;

    public Endereco() {
    }

    public Endereco(String rua, String numero, String bairro, String cidade) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public Endereco(ChamadoRequestDTO chamadoRequestDTO) {
        this.rua = chamadoRequestDTO.getEndereco().getRua();
        this.numero = chamadoRequestDTO.getEndereco().getNumero();
        this.bairro = chamadoRequestDTO.getEndereco().getBairro();
        this.cidade = chamadoRequestDTO.getEndereco().getCidade();
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
