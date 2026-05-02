package com.projeto.lina.controller;

import com.projeto.lina.dto.LoginDTO;
import com.projeto.lina.dto.LoginResponseDTO;
import com.projeto.lina.service.AuthService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /**
     * POST /auth/login
     *
     * Body:
     * {
     *   "email": "usuario@email.com",
     *   "senha": "minhasenha"
     * }
     *
     * Response 200:
     * {
     *   "token": "eyJhbGci...",
     *   "usuarioId": 1,
     *   "nome": "Maria Silva",
     *   "email": "usuario@email.com"
     * }
     *
     * Response 401: credenciais inválidas
     */
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@Valid @RequestBody LoginDTO dto) {
        LoginResponseDTO response = authService.login(dto);
        return ResponseEntity.ok(response);
    }
}
