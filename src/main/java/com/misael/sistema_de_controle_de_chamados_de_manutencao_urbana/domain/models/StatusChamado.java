package com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.models;

import java.time.LocalDateTime;

public enum StatusChamado {
    ABERTO("Aberto"),
    EM_ANDAMENTO("Em Andamento"),
    RESOLVIDO("Resolvido");

    private final String statusChamado;

    StatusChamado(String statusChamado) {
        this.statusChamado = statusChamado;
    }

    public String getStatusChamado() {
        return statusChamado;
    }
}
