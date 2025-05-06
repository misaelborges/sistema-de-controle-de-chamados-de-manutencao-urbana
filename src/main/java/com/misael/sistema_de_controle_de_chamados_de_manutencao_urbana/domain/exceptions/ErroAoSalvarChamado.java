package com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.exceptions;

public class ErroAoSalvarChamado extends RuntimeException{

    public ErroAoSalvarChamado() {
    }

    public ErroAoSalvarChamado(String message) {
        super(message);
    }

    public ErroAoSalvarChamado(String message, Throwable cause) {
        super(message, cause);
    }
}
