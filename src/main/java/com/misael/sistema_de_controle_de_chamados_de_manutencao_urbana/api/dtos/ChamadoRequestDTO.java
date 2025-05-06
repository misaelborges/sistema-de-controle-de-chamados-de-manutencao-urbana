package com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.api.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ChamadoRequestDTO {

    @NotBlank(message = "O campo descriçao não pode ser em branco")
    private String descricao;

    @Valid
    @NotNull
    private EnderecoRequestDTO endereco;

    @Valid
    @NotNull
    private CategoriaRequestDTO categoria;

    public ChamadoRequestDTO() {
    }

    public ChamadoRequestDTO(String descricao, EnderecoRequestDTO endereco, CategoriaRequestDTO categoria) {
        this.descricao = descricao;
        this.endereco = endereco;
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public EnderecoRequestDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoRequestDTO endereco) {
        this.endereco = endereco;
    }

    public CategoriaRequestDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaRequestDTO categoria) {
        this.categoria = categoria;
    }
}
