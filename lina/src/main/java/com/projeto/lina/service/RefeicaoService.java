package com.projeto.lina.service;

import com.projeto.lina.exception.EntidadeNaoEncontradaException;
import com.projeto.lina.model.*;
import com.projeto.lina.repository.*;
import com.projeto.lina.dto.RefeicaoResponseDTO;
import com.projeto.lina.mapper.RefeicaoMapper;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefeicaoService {

    private final RefeicaoRepository refeicaoRepository;
    private final UsuarioRepository usuarioRepository;

    public RefeicaoService(RefeicaoRepository refeicaoRepository,
                           UsuarioRepository usuarioRepository) {
        this.refeicaoRepository = refeicaoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<RefeicaoResponseDTO> listarPorPeriodoEUsuario(
            PeriodoDia periodo,
            Long usuarioId) {

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Usuário não encontrado"));

        List<Refeicao> refeicoes;

        if (usuario.getRestricoes() == null || usuario.getRestricoes().isEmpty()) {
            // sem restrições → só filtra por período
            refeicoes = refeicaoRepository.findByPeriodo(periodo);
        } else {
            refeicoes = refeicaoRepository.buscarValidas(
                    periodo,
                    usuario.getRestricoes()
            );
        }

        return refeicoes.stream()
                .map(RefeicaoMapper::toDTO)
                .toList();
    }
}