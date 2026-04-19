package com.projeto.lina.controller;

import com.projeto.lina.dto.ListaComprasDTO;
import com.projeto.lina.service.ListaComprasService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lista-compras")
public class ListaComprasController {

    private final ListaComprasService service;

    public ListaComprasController(ListaComprasService service) {
        this.service = service;
    }

    @GetMapping("/{usuarioId}")
    public List<ListaComprasDTO> gerar(@PathVariable Long usuarioId) {
        return service.gerarLista(usuarioId);
    }
}