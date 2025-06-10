package com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.api.dtos;

import com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.models.StatusChamado;

public class ChamadoStatusCountDTO {
    private StatusChamado status;
    private Long total;

    public ChamadoStatusCountDTO(StatusChamado status, Long total) {
        this.status = status;
        this.total = total;
    }

    public StatusChamado getStatus() {
        return status;
    }

    public Long getTotal() {
        return total;
    }
}

