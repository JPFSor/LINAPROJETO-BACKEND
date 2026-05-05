package com.projeto.lina.controller;

import com.projeto.lina.dto.ListaComprasDTO;
import com.projeto.lina.security.AuthUtils;
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

    /**
     * GET /lista-compras/{usuarioId}
     * Gera a lista de compras consolidada do plano semanal do usuário.
     */
    @GetMapping("/{usuarioId}")
    public List<ListaComprasDTO> gerar(@PathVariable Long usuarioId) {
        AuthUtils.verificarProprietario(usuarioId);
        return service.gerarLista(usuarioId);
    }
}
