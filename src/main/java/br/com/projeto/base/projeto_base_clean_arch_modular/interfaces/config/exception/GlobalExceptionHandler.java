package br.com.projeto.base.projeto_base_clean_arch_modular.interfaces.config.exception;

import br.com.projeto.base.projeto_base_clean_arch_modular.domain.exception.BusinessValidateException;
import br.com.projeto.base.projeto_base_clean_arch_modular.domain.exception.enums.ErroCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleRuntimeException(Exception ex, WebRequest request) {
        log.error(ex.getMessage(), ex);
        String message = "Erro interno do servidor";
        return this.handleExceptionInternal(ex, message, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(BusinessValidateException.class)
    protected ResponseEntity<Object> handleBusinessValidateException(BusinessValidateException ex,  WebRequest request) {
        log.error(ex.getMessage(), ex);
        ApiErro apiErro = new ApiErro(ex.getCode(), ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return this.handleExceptionInternal(ex, apiErro, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> fieldErrors = new HashMap<>();

        log.error("Erro de validação: {}", fieldErrors);

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            fieldErrors.put(error.getField(), error.getDefaultMessage());
        });

        ApiErro apiErro = new ApiErro(ErroCodeEnum.UC0001.getCode(), ErroCodeEnum.UC0001.getMessage(),
                HttpStatus.BAD_REQUEST.value(), fieldErrors);

        return handleExceptionInternal(ex, apiErro, headers, HttpStatus.BAD_REQUEST, request);
    }

}
