package com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.exceptions;

public class ErroAoEncontrarChamadoException extends RuntimeException{

    public ErroAoEncontrarChamadoException() {
    }

    public ErroAoEncontrarChamadoException(String message) {
        super(message);
    }

    public ErroAoEncontrarChamadoException(String message, Throwable cause) {
        super(message, cause);
    }
}
