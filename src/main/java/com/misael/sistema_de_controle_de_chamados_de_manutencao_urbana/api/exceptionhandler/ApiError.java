package com.misael.sistema_de_controle_de_chamados_de_manutencao_urbana.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {

    private Integer status;
    private String type;
    private String title;
    private String detail;

    // Construtor privado - só pode ser usado pelo Builder
    private ApiError(Builder builder) {
        this.status = builder.status;
        this.type = builder.type;
        this.title = builder.title;
        this.detail = builder.detail;
    }

    public ApiError() {
    }

    public ApiError(Integer status, String type, String title, String detail) {
        this.status = status;
        this.type = type;
        this.title = title;
        this.detail = detail;
    }

    // Método estático para criar um Builder
    public static Builder builder() {
        return new Builder();
    }

    public Integer getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getDetail() {
        return detail;
    }

    // Classe Builder interna - Padrão usado por Google, Spring, etc.
    public static class Builder {
        private Integer status;
        private String type;
        private String title;
        private String detail;

        // Construtor privado
        private Builder() {
        }

        public Builder status(Integer status) {
            this.status = status;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder detail(String detail) {
            this.detail = detail;
            return this;
        }

        // Validações opcionais antes de construir
        public ApiError build() {
            // Exemplo de validação empresarial
            if (status == null) {
                throw new IllegalStateException("Status é obrigatório");
            }

            return new ApiError(this);
        }
    }

    // Métodos úteis adicionais
    @Override
    public String toString() {
        return "ApiError{" +
                "status=" + status +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApiError apiError = (ApiError) o;

        if (status != null ? !status.equals(apiError.status) : apiError.status != null) return false;
        if (type != null ? !type.equals(apiError.type) : apiError.type != null) return false;
        if (title != null ? !title.equals(apiError.title) : apiError.title != null) return false;
        return detail != null ? detail.equals(apiError.detail) : apiError.detail == null;
    }

    @Override
    public int hashCode() {
        int result = status != null ? status.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (detail != null ? detail.hashCode() : 0);
        return result;
    }
}