package com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.models;

import jakarta.persistence.*;

@Embeddable
public class CategoriaRequestDTO {

    @Enumerated(EnumType.STRING)
    private CategoriaTipo categoriaTipo;

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

    public String getDescricao() {
        return descricao;
    }
}
