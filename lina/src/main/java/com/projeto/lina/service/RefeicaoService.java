package com.projeto.lina.service;

import com.projeto.lina.exception.EntidadeNaoEncontradaException;
import com.projeto.lina.model.*;
import com.projeto.lina.repository.*;
import com.projeto.lina.dto.RefeicaoResponseDTO;
import com.projeto.lina.mapper.RefeicaoMapper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(readOnly = true)
    public List<RefeicaoResponseDTO> listarPorPeriodoEUsuario(
            PeriodoDia periodo,
            Long usuarioId) {

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Usuário não encontrado"));

        List<Refeicao> refeicoes;

        if (usuario.getRestricoes() == null || usuario.getRestricoes().isEmpty()) {
            refeicoes = refeicaoRepository.findByPeriodo(periodo);
        } else {
            refeicoes = refeicaoRepository.buscarValidas(
                    periodo,
                    usuario.getRestricoes()
            );
            // Fallback: se o filtro de restrições excluiu TUDO, mostra todas do período
            if (refeicoes.isEmpty()) {
                refeicoes = refeicaoRepository.findByPeriodo(periodo);
            }
        }

        return refeicoes.stream()
                .map(RefeicaoMapper::toDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public RefeicaoResponseDTO buscarPorId(Long id, Long usuarioId, PeriodoDia periodo) {
        if (usuarioId != null) {
            usuarioRepository.findById(usuarioId)
                    .orElseThrow(() -> new EntidadeNaoEncontradaException("Usuário não encontrado"));
        }

        Refeicao refeicao = refeicaoRepository.findDetalheById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Refeição não encontrada"));

        PeriodoDia periodoResolvido = resolverPeriodo(refeicao, periodo);
        return RefeicaoMapper.toDetalheDTO(refeicao, periodoResolvido);
    }

    private static PeriodoDia resolverPeriodo(Refeicao refeicao, PeriodoDia periodoInformado) {
        if (periodoInformado != null) {
            return periodoInformado;
        }
        List<PeriodoDia> permitidos = refeicao.getPeriodosPermitidos();
        if (permitidos != null && !permitidos.isEmpty()) {
            return permitidos.get(0);
        }
        return null;
    }
}
