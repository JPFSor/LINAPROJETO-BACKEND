package com.projeto.lina.controller;

import com.projeto.lina.dto.RefeicaoResponseDTO;
import com.projeto.lina.model.PeriodoDia;
import com.projeto.lina.service.RefeicaoService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/refeicoes")
public class RefeicaoController {

    private final RefeicaoService service;

    public RefeicaoController(RefeicaoService service) {
        this.service = service;
    }

    @GetMapping
    public List<RefeicaoResponseDTO> listar(
            @RequestParam PeriodoDia periodo,
            @RequestParam Long usuarioId) {

        return service.listarPorPeriodoEUsuario(periodo, usuarioId);
    }

    @GetMapping("/{id}")
    public RefeicaoResponseDTO buscar(
            @PathVariable Long id,
            @RequestParam(required = false) Long usuarioId,
            @RequestParam(required = false) PeriodoDia periodo) {

        return service.buscarPorId(id, usuarioId, periodo);
    }
}
