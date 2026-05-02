package com.projeto.lina.service;

import com.projeto.lina.dto.AssinaturaResponseDTO;
import com.projeto.lina.exception.EntidadeNaoEncontradaException;
import com.projeto.lina.model.Usuario;
import com.projeto.lina.repository.UsuarioRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AssinaturaService {

    private final UsuarioRepository usuarioRepository;

    public AssinaturaService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Ativa a assinatura premium do usuário.
     *
     * Em produção, este método deve ser chamado APÓS confirmação
     * do pagamento pelo gateway (webhook do Stripe, MercadoPago, etc.).
     * Por ora, ativa diretamente para permitir integração com o app.
     */
    public AssinaturaResponseDTO ativar(Long usuarioId) {

        Usuario usuario = buscarUsuario(usuarioId);

        if (usuario.isAssinante()) {
            // Já é assinante — renova por mais 30 dias a partir de hoje
            LocalDate novaRenovacao = LocalDate.now().plusDays(30);
            usuario.setDataRenovacaoAssinatura(novaRenovacao);
        } else {
            // Primeira assinatura
            LocalDate hoje = LocalDate.now();
            usuario.setAssinante(true);
            usuario.setDataInicioAssinatura(hoje);
            usuario.setDataRenovacaoAssinatura(hoje.plusDays(30));
        }

        usuarioRepository.save(usuario);

        return new AssinaturaResponseDTO(
                usuario.getId(),
                usuario.isAssinante(),
                usuario.getDataInicioAssinatura(),
                usuario.getDataRenovacaoAssinatura(),
                "Assinatura ativada com sucesso!"
        );
    }

    /**
     * Cancela a assinatura do usuário.
     * O acesso premium se mantém até dataRenovacaoAssinatura.
     */
    public AssinaturaResponseDTO cancelar(Long usuarioId) {

        Usuario usuario = buscarUsuario(usuarioId);

        if (!usuario.isAssinante()) {
            throw new IllegalStateException("Usuário não possui assinatura ativa");
        }

        usuario.setAssinante(false);
        usuarioRepository.save(usuario);

        return new AssinaturaResponseDTO(
                usuario.getId(),
                false,
                usuario.getDataInicioAssinatura(),
                usuario.getDataRenovacaoAssinatura(),
                "Assinatura cancelada. Acesso premium disponível até " +
                        usuario.getDataRenovacaoAssinatura()
        );
    }

    /**
     * Retorna o status atual da assinatura.
     */
    public AssinaturaResponseDTO status(Long usuarioId) {

        Usuario usuario = buscarUsuario(usuarioId);

        return new AssinaturaResponseDTO(
                usuario.getId(),
                usuario.isAssinante(),
                usuario.getDataInicioAssinatura(),
                usuario.getDataRenovacaoAssinatura(),
                usuario.isAssinante() ? "Assinatura ativa" : "Sem assinatura ativa"
        );
    }

    private Usuario buscarUsuario(Long usuarioId) {
        return usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Usuário não encontrado"));
    }
}
