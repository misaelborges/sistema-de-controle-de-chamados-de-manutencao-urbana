package com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.models;

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
    private StatusChamado statusAtual;

    private String comentarioServidor;

    @Embedded
    private CategoriaRequestDTO categoria;

    public Chamado() {
    }

    public Chamado(String descricao, Endereco endereco, LocalDateTime dataAbertura, LocalDateTime dataResolucao,
                   StatusChamado statusAtual, String comentarioServidor, CategoriaRequestDTO categoria) {
        this.descricao = descricao;
        this.endereco = endereco;
        this.dataAbertura = dataAbertura;
        this.dataResolucao = dataResolucao;
        this.statusAtual = statusAtual;
        this.comentarioServidor = comentarioServidor;
        this.categoria = categoria;
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

    public CategoriaRequestDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaRequestDTO categoria) {
        this.categoria = categoria;
    }

}
