package com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.api.dtos;

import com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.models.CategoriaTipo;
import jakarta.validation.constraints.NotBlank;

public class CategoriaRequestDTO {

    @NotBlank(message = "O campo categoria não pode ser em branco")
    private CategoriaTipo categoriaTipo;

    @NotBlank
    private String descricao;

    public CategoriaRequestDTO() {
    }

    public CategoriaRequestDTO(CategoriaTipo categoriaTipo, String descricao) {
        this.categoriaTipo = categoriaTipo;
        this.descricao = descricao;
    }

    public CategoriaTipo getCategoriaTipo() {
        return categoriaTipo;
    }

    public void setCategoriaTipo(CategoriaTipo categoriaTipo) {
        this.categoriaTipo = categoriaTipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
