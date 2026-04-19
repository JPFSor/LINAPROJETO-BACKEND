package com.projeto.lina.controller;

import com.projeto.lina.dto.UsuarioCreateDTO;
import com.projeto.lina.dto.UsuarioResponseDTO;
import com.projeto.lina.dto.UsuarioUpdateDTO;

import com.projeto.lina.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public UsuarioResponseDTO criar(@RequestBody UsuarioCreateDTO dto) {
        return service.criarUsuario(dto);
    }

    @GetMapping
    public List<UsuarioResponseDTO> listar() {
        return service.listarUsuarios();
    }

    @GetMapping("/{id}")
    public UsuarioResponseDTO buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public UsuarioResponseDTO atualizar(
            @PathVariable Long id,
            @RequestBody UsuarioUpdateDTO dto) {

        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}