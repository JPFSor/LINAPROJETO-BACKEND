package com.projeto.lina.controller;

import com.projeto.lina.dto.NutricionistaResponseDTO;
import com.projeto.lina.service.NutricionistaService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nutricionistas")
public class NutricionistaController {

    private final NutricionistaService service;

    public NutricionistaController(NutricionistaService service) {
        this.service = service;
    }

    /**
     * GET /nutricionistas
     * GET /nutricionistas?cidade=Sorocaba
     *
     * Retorna lista ordenada por avaliação (maior primeiro).
     * O parâmetro cidade é opcional — sem ele retorna todos.
     */
    @GetMapping
    public List<NutricionistaResponseDTO> listar(
            @RequestParam(required = false) String cidade) {

        return service.listar(cidade);
    }

    /**
     * GET /nutricionistas/{id}
     *
     * Retorna detalhes de um nutricionista específico.
     */
    @GetMapping("/{id}")
    public NutricionistaResponseDTO buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}
