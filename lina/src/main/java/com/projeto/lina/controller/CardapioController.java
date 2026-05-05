package com.projeto.lina.controller;

import com.projeto.lina.dto.CardapioDTO;
import com.projeto.lina.security.AuthUtils;
import com.projeto.lina.service.CardapioService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cardapio")
public class CardapioController {

    private final CardapioService cardapioService;

    public CardapioController(CardapioService cardapioService) {
        this.cardapioService = cardapioService;
    }

    /**
     * GET /cardapio/{usuarioId}
     * Retorna os 7 cardápios da semana do usuário com suas refeições.
     */
    @GetMapping("/{usuarioId}")
    public List<CardapioDTO> listar(@PathVariable Long usuarioId) {
        AuthUtils.verificarProprietario(usuarioId);
        return cardapioService.listarPorUsuario(usuarioId);
    }
}
