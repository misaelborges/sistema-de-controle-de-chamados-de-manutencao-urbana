package com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.api.dtos;

import com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.models.CategoriaTipo;
import jakarta.validation.constraints.NotNull;

public class CategoriaRequestDTO {

    @NotNull(message = "O campo categoria não pode ser nulo")
    private CategoriaTipo categoriaTipo;


    public CategoriaRequestDTO() {
    }

    public CategoriaRequestDTO(CategoriaTipo categoriaTipo) {
        this.categoriaTipo = categoriaTipo;
    }

    public CategoriaTipo getCategoriaTipo() {
        return categoriaTipo;
    }

    public void setCategoriaTipo(CategoriaTipo categoriaTipo) {
        this.categoriaTipo = categoriaTipo;
    }
}
