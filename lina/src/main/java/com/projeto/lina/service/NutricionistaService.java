package com.projeto.lina.service;

import com.projeto.lina.dto.NutricionistaResponseDTO;
import com.projeto.lina.exception.EntidadeNaoEncontradaException;
import com.projeto.lina.mapper.NutricionistaMapper;
import com.projeto.lina.repository.NutricionistaRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NutricionistaService {

    private final NutricionistaRepository nutricionistaRepository;

    public NutricionistaService(NutricionistaRepository nutricionistaRepository) {
        this.nutricionistaRepository = nutricionistaRepository;
    }

    // Lista todos ou filtra por cidade
    // GET /nutricionistas          → todos
    // GET /nutricionistas?cidade=Sorocaba → filtrado
    public List<NutricionistaResponseDTO> listar(String cidade) {

        var nutricionistas = (cidade == null || cidade.isBlank())
                ? nutricionistaRepository.findAllOrdenadosPorAvaliacao()
                : nutricionistaRepository.findByCidade(cidade);

        return nutricionistas.stream()
                .map(NutricionistaMapper::toDTO)
                .toList();
    }

    // Busca um específico pelo id
    // GET /nutricionistas/{id}
    public NutricionistaResponseDTO buscarPorId(Long id) {
        return nutricionistaRepository.findById(id)
                .map(NutricionistaMapper::toDTO)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Nutricionista não encontrado"));
    }
}
