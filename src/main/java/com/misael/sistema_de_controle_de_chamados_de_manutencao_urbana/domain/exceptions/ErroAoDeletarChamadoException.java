package com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.exceptions;

public class ErroAoDeletarChamadoException extends RuntimeException {

    public ErroAoDeletarChamadoException() {
    }

    public ErroAoDeletarChamadoException(String message) {
        super(message);
    }

    public ErroAoDeletarChamadoException(String message, Throwable cause) {
        super(message, cause);
    }
}
