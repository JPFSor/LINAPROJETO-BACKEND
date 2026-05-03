package com.projeto.lina.controller;

import com.projeto.lina.dto.AssinaturaResponseDTO;
import com.projeto.lina.dto.ListaComprasDTO;
import com.projeto.lina.security.AuthUtils;
import com.projeto.lina.service.AssinaturaService;
import com.projeto.lina.service.ListaComprasService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lista-compras")
public class ListaComprasController {

    private final ListaComprasService service;
    private final AssinaturaService assinaturaService;

    public ListaComprasController(ListaComprasService service, AssinaturaService assinaturaService) {
        this.service = service;
        this.assinaturaService = assinaturaService;
    }

    @GetMapping
    public ResponseEntity<AssinaturaResponseDTO> status(@PathVariable Long usuarioId) {
        AuthUtils.verificarProprietario(usuarioId);
        return ResponseEntity.ok(assinaturaService.status(usuarioId));
    }

    @GetMapping("/{usuarioId}")
    public List<ListaComprasDTO> gerar(@PathVariable Long usuarioId) {
        return service.gerarLista(usuarioId);
    }
}