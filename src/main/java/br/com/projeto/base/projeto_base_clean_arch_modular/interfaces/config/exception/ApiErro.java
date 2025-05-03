package br.com.projeto.base.projeto_base_clean_arch_modular.interfaces.config.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiErro {
    private String code;
    private String message;
    private int statusHttp;
    private LocalDateTime timestamp;
    private Map<String, String> detalhes;

    public ApiErro(String code, String message, int statusHttp) {
        this.code = code;
        this.message = message;
        this.statusHttp = statusHttp;
        this.timestamp = LocalDateTime.now();
    }

    public ApiErro(String code, String message, int statusHttp, Map<String, String> detalhes) {
        this(code, message, statusHttp);
        this.timestamp = LocalDateTime.now();
        this.detalhes = detalhes;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusHttp() {
        return statusHttp;
    }

    public void setStatusHttp(int statusHttp) {
        this.statusHttp = statusHttp;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Map<String, String> getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(Map<String, String> detalhes) {
        this.detalhes = detalhes;
    }
}