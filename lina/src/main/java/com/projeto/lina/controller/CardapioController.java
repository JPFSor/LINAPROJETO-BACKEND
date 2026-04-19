package com.projeto.lina.controller;

import com.projeto.lina.dto.CardapioDTO;
import com.projeto.lina.mapper.CardapioMapper;
import com.projeto.lina.model.PlanoSemanal;
import com.projeto.lina.repository.PlanoSemanalRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cardapio")
public class CardapioController {

    private final PlanoSemanalRepository planoRepository;

    public CardapioController(PlanoSemanalRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    @GetMapping("/{usuarioId}")
    public List<CardapioDTO> listar(@PathVariable Long usuarioId) {

        PlanoSemanal plano = planoRepository.findByUsuarioId(usuarioId)
                .orElseThrow(() -> new RuntimeException("Plano não encontrado"));

        return plano.getCardapios()
                .stream()
                .map(CardapioMapper::toDTO)
                .toList();
    }
}