package com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.models;

import com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.api.dtos.ChamadoRequestDTO;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @Embedded
    private Endereco endereco;

    @CreationTimestamp
    private LocalDateTime dataAbertura;

    @UpdateTimestamp
    private LocalDateTime dataResolucao;

    @Enumerated(EnumType.STRING)
    private StatusChamado statusAtual = StatusChamado.ABERTO;

    private String comentarioServidor;

    @Enumerated(EnumType.STRING)
    private CategoriaTipo categoria;

    public Chamado() {
    }

    public Chamado(ChamadoRequestDTO chamadoRequestDTO) {
        this.descricao = chamadoRequestDTO.getDescricao();
        this.endereco = new Endereco(chamadoRequestDTO);
        this.categoria = chamadoRequestDTO.getCategoria().getCategoriaTipo();
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDateTime getDataResolucao() {
        return dataResolucao;
    }

    public void setDataResolucao(LocalDateTime dataResolucao) {
        this.dataResolucao = dataResolucao;
    }

    public StatusChamado getStatusAtual() {
        return statusAtual;
    }

    public void setStatusAtual(StatusChamado statusAtual) {
        this.statusAtual = statusAtual;
    }

    public String getComentarioServidor() {
        return comentarioServidor;
    }

    public void setComentarioServidor(String comentarioServidor) {
        this.comentarioServidor = comentarioServidor;
    }

    public CategoriaTipo getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaTipo categoria) {
        this.categoria = categoria;
    }

}
