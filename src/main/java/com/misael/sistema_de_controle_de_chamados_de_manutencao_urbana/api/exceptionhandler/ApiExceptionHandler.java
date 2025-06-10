package com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.api.exceptionhandler;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.domain.exceptions.ErroAoEncontrarChamadoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ErroAoEncontrarChamadoException.class)
    public ResponseEntity<ApiError> handleErroAoEncontrarChamadoException(ErroAoEncontrarChamadoException e) {
        ApiError apiError = ApiError.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .type("CHAMADO_NAO_ENCONTRADO")
                .title("Chamado não encontrado")
                .detail(e.getMessage())
        .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ApiError> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        ApiError apiError = ApiError.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .type("ERRO_DE_URL")
                .title("Erro de parametro de url")
                .detail(String.format("O parametro da '%s' da url recebeu um valor '%s', que é de um tipo invalido",
                        e.getName(), e.getValue()))
        .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleHttpMessageNotReadableException(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();

        for (FieldError error : e.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }

        ApiError apiError = ApiError.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .type("CORPO_REQUISICAO_INVALIDO")
                .title("Corpo da requisição inválido")
                .detail(e.getFieldError().getDefaultMessage())
        .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }


}
