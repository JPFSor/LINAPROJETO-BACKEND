package com.projeto.lina.controller;

import com.projeto.lina.dto.UsuarioCreateDTO;
import com.projeto.lina.dto.UsuarioResponseDTO;
import com.projeto.lina.dto.UsuarioUpdateDTO;
import com.projeto.lina.security.AuthUtils;
import com.projeto.lina.service.UsuarioService;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criar(@Valid @RequestBody UsuarioCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criarUsuario(dto));
    }

    @GetMapping
    public Page<UsuarioResponseDTO> listar(Pageable pageable) {
        return service.listarUsuarios(pageable);
    }

    @GetMapping("/{id}")
    public UsuarioResponseDTO buscar(@PathVariable Long id) {
        AuthUtils.verificarProprietario(id);
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public UsuarioResponseDTO atualizar(@PathVariable Long id,
                                        @Valid @RequestBody UsuarioUpdateDTO dto) {
        AuthUtils.verificarProprietario(id);
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        AuthUtils.verificarProprietario(id);
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}