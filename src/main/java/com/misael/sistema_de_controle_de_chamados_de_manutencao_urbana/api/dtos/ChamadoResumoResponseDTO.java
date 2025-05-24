package com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.api.dtos;

import com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.models.Chamado;
import com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.models.StatusChamado;

import java.time.LocalDateTime;

public class ChamadoResumoResponseDTO {

    private Long id;
    private String descricao;
    private String bairro;
    private String cidade;
    private LocalDateTime dataAbertura;
    private StatusChamado statusAtual;
    private String categoria;

    public ChamadoResumoResponseDTO() {
    }

    public ChamadoResumoResponseDTO(Chamado chamado) {
        this.id = chamado.getId();
        this.descricao = chamado.getDescricao();
        this.bairro = chamado.getEndereco().getBairro();
        this.cidade = chamado.getEndereco().getCidade();
        this.dataAbertura = chamado.getDataAbertura();
        this.statusAtual = chamado.getStatusAtual();
        this.categoria = chamado.getCategoria().getDescricaoTipo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
