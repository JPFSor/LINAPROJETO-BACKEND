package com.projeto.lina.service;

import com.projeto.lina.dto.CardapioDTO;
import com.projeto.lina.exception.EntidadeNaoEncontradaException;
import com.projeto.lina.mapper.CardapioMapper;
import com.projeto.lina.model.PlanoSemanal;
import com.projeto.lina.repository.PlanoSemanalRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CardapioService {

    private final PlanoSemanalRepository planoRepository;

    public CardapioService(PlanoSemanalRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    /**
     * Retorna todos os cardápios da semana do usuário,
     * com itens e refeições carregados em uma única query (sem N+1).
     */
    @Transactional(readOnly = true)
    public List<CardapioDTO> listarPorUsuario(Long usuarioId) {
        PlanoSemanal plano = planoRepository.findByUsuarioIdComItens(usuarioId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Plano não encontrado"));

        return plano.getCardapios()
                .stream()
                .map(CardapioMapper::toDTO)
                .toList();
    }
}
