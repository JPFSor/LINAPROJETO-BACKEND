package com.projeto.lina.controller;

import com.projeto.lina.dto.AssinaturaResponseDTO;
import com.projeto.lina.dto.CardapioDTO;
import com.projeto.lina.exception.EntidadeNaoEncontradaException;
import com.projeto.lina.mapper.CardapioMapper;
import com.projeto.lina.model.PlanoSemanal;
import com.projeto.lina.repository.PlanoSemanalRepository;

import com.projeto.lina.security.AuthUtils;
import com.projeto.lina.service.AssinaturaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cardapio")
public class CardapioController {

    private final PlanoSemanalRepository planoRepository;
    private final AssinaturaService assinaturaService;

    public CardapioController(PlanoSemanalRepository planoRepository, AssinaturaService assinaturaService) {
        this.planoRepository = planoRepository;
        this.assinaturaService = assinaturaService;
    }

    @GetMapping
    public ResponseEntity<AssinaturaResponseDTO> status(@PathVariable Long usuarioId) {
        AuthUtils.verificarProprietario(usuarioId);
        return ResponseEntity.ok(assinaturaService.status(usuarioId));
    }

    @GetMapping("/{usuarioId}")
    public List<CardapioDTO> listar(@PathVariable Long usuarioId) {

        PlanoSemanal plano = planoRepository.findByUsuarioId(usuarioId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Plano não encontrado"));

        return plano.getCardapios()
                .stream()
                .map(CardapioMapper::toDTO)
                .toList();
    }
}