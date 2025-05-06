package com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.api.dtos;

import com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.models.CategoriaTipo;
import jakarta.validation.constraints.NotBlank;

public class CategoriaRequestDTO {

    @NotBlank(message = "O campo categoria não pode ser em branco")
    private CategoriaTipo categoriaTipo;

    @NotBlank
    private String descricaoTipo;

    public CategoriaRequestDTO() {
    }

    public CategoriaRequestDTO(CategoriaTipo categoriaTipo, String descricaoTipo) {
        this.categoriaTipo = categoriaTipo;
        this.descricaoTipo = descricaoTipo;
    }

    public CategoriaTipo getCategoriaTipo() {
        return categoriaTipo;
    }

    public void setCategoriaTipo(CategoriaTipo categoriaTipo) {
        this.categoriaTipo = categoriaTipo;
    }

    public String getDescricaoTipo() {
        return descricaoTipo;
    }

    public void setDescricaoTipo(String descricaoTipo) {
        this.descricaoTipo = descricaoTipo;
    }
}
