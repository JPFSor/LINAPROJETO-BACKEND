package com.projeto.lina.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // -------------------------------------------------------
    // 404 - Entidade não encontrada
    // ex: usuário, plano, refeição inexistentes
    // -------------------------------------------------------
    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<Map<String, Object>> handleNotFound(EntidadeNaoEncontradaException ex) {
        return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    // -------------------------------------------------------
    // 401 - Credenciais inválidas no login
    // -------------------------------------------------------
    @ExceptionHandler(CredenciaisInvalidasException.class)
    public ResponseEntity<Map<String, Object>> handleCredenciais(CredenciaisInvalidasException ex) {
        return buildResponse(HttpStatus.UNAUTHORIZED, ex.getMessage());
    }

    // -------------------------------------------------------
    // 400 - Falha de validação (@Valid nos DTOs)
    // ex: email inválido, campo obrigatório vazio
    // -------------------------------------------------------
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidacao(MethodArgumentNotValidException ex) {

        Map<String, String> errosPorCampo = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(erro ->
                errosPorCampo.put(erro.getField(), erro.getDefaultMessage())
        );

        Map<String, Object> body = new HashMap<>();
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("erro", "Dados inválidos");
        body.put("campos", errosPorCampo);
        body.put("timestamp", LocalDateTime.now().toString());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    // -------------------------------------------------------
    // 409 - Conflito (ex: email já cadastrado)
    // -------------------------------------------------------
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<Map<String, Object>> handleConflito(IllegalStateException ex) {
        return buildResponse(HttpStatus.CONFLICT, ex.getMessage());
    }

    // -------------------------------------------------------
    // 500 - Erro genérico inesperado
    // Não expõe stack trace — apenas mensagem segura
    // -------------------------------------------------------
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenerico(Exception ex) {
        // Log interno (em produção use SLF4J/Logback aqui)
        ex.printStackTrace();
        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno do servidor");
    }

    // -------------------------------------------------------
    // Utilitário: monta o corpo padrão de erro
    // -------------------------------------------------------
    private ResponseEntity<Map<String, Object>> buildResponse(HttpStatus status, String mensagem) {
        Map<String, Object> body = new HashMap<>();
        body.put("status", status.value());
        body.put("erro", mensagem);
        body.put("timestamp", LocalDateTime.now().toString());
        return ResponseEntity.status(status).body(body);
    }
}
