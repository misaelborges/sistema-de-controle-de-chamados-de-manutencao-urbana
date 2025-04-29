package com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.models;

public enum CategoriaTipo {
    ILUMINACAO_PUBLICA("Iluminação pública"),
    PAVIMENTACAO("Pavimentação"),
    COLETA_DE_LIXO("Coleta de Lixo"),
    LIMPEZA_URBANA("Limpeza Urbana"),
    ESGOTO_ENTUPIDO("Esgoto entupido"),
    VAZAMENTO_DE_AGUA("Vazamento de Agua"),
    ARBORIZACAO("Arborização"),
    ANIMAIS_SOLTOS_NA_RUA("Animais Soltos na Rua"),
    TRANSPORTE_PUBLICO("Transporte Público"),
    FISCALIZACAO_SANITARIA("Fiscalização Sanitaria"),
    BURACO_NA_VIA("Buraco na Via"),
    SINALIZACAO_DE_TRANSITO("Sinalização de Transito"),
    OBRA_ABANDONADA("Obra Abandonada"),
    LOTE_SUJO("Lote Sujo"),
    FALTA_DE_AGUA("Falta de Agua"),
    POSTE_QUEMADO("Poste quemado"),
    ALAGAMENTO("Alagamento");

    private final String descricao;

    CategoriaTipo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
