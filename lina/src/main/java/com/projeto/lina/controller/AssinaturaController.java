package com.projeto.lina.controller;

import com.projeto.lina.dto.AssinaturaResponseDTO;
import com.projeto.lina.security.AuthUtils;
import com.projeto.lina.service.AssinaturaService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios/{usuarioId}/assinatura")
public class AssinaturaController {

    private final AssinaturaService assinaturaService;

    public AssinaturaController(AssinaturaService assinaturaService) {
        this.assinaturaService = assinaturaService;
    }

    /**
     * GET /usuarios/{usuarioId}/assinatura
     * Retorna o status atual da assinatura do usuário.
     */
    @GetMapping
    public ResponseEntity<AssinaturaResponseDTO> status(@PathVariable Long usuarioId) {
        AuthUtils.verificarProprietario(usuarioId);
        return ResponseEntity.ok(assinaturaService.status(usuarioId));
    }

    /**
     * POST /usuarios/{usuarioId}/assinatura/ativar
     *
     * Ativa ou renova a assinatura premium.
     * Em produção: chamar via webhook do gateway de pagamento,
     * não diretamente pelo app.
     */
    @PostMapping("/ativar")
    public ResponseEntity<AssinaturaResponseDTO> ativar(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(assinaturaService.ativar(usuarioId));
    }

    /**
     * DELETE /usuarios/{usuarioId}/assinatura/cancelar
     * Cancela a assinatura. Acesso premium mantido até data de renovação.
     */
    @DeleteMapping("/cancelar")
    public ResponseEntity<AssinaturaResponseDTO> cancelar(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(assinaturaService.cancelar(usuarioId));
    }
}
