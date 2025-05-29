package com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.api.dtos;

import com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.models.StatusChamado;

public class ChamadoAtualizarStatusDTO {

    private StatusChamado statusChamado;
    private String comentarioServidor;

    public ChamadoAtualizarStatusDTO() {
    }

    public ChamadoAtualizarStatusDTO(StatusChamado statusChamado, String comentarioServidor) {
        this.statusChamado = statusChamado;
        this.comentarioServidor = comentarioServidor;
    }

    public StatusChamado getStatusChamado() {
        return statusChamado;
    }

    public void setStatusChamado(StatusChamado statusChamado) {
        this.statusChamado = statusChamado;
    }

    public String getComentarioServidor() {
        return comentarioServidor;
    }

    public void setComentarioServidor(String comentarioServidor) {
        this.comentarioServidor = comentarioServidor;
    }
}
