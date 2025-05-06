package com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.api.dtos;

import com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.models.CategoriaTipo;
import com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.models.Chamado;
import com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.models.StatusChamado;

import java.time.LocalDateTime;

public class ChamadoResponseDTO {

    private String descricao;
    private EnderecoResponseDTO endereco;
    private LocalDateTime dataAbertura;
    private StatusChamado statusAtual;
    private CategoriaTipo categoria;

    public ChamadoResponseDTO() {
    }

    public ChamadoResponseDTO(Chamado chamado) {
        this.descricao = chamado.getDescricao();
        this.endereco = new EnderecoResponseDTO(chamado);
        this.dataAbertura = chamado.getDataAbertura();
        this.statusAtual = chamado.getStatusAtual();
        this.categoria = chamado.getCategoria();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public EnderecoResponseDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoResponseDTO endereco) {
        this.endereco = endereco;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public StatusChamado getStatusAtual() {
        return statusAtual;
    }

    public void setStatusAtual(StatusChamado statusAtual) {
        this.statusAtual = statusAtual;
    }

    public CategoriaTipo getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaTipo categoria) {
        this.categoria = categoria;
    }
}
