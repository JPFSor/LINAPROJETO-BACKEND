package com.projeto.lina.mapper;

import com.projeto.lina.dto.NutricionistaResponseDTO;
import com.projeto.lina.model.Nutricionista;

public class NutricionistaMapper {

    private NutricionistaMapper() {}

    public static NutricionistaResponseDTO toDTO(Nutricionista n) {

        String cidade = null;
        String estado = null;

        if (n.getEndereco() != null) {
            cidade = n.getEndereco().getCidade();
            estado = n.getEndereco().getEstado();
        }

        return NutricionistaResponseDTO.builder()
                .id(n.getId())
                .nome(n.getNome())
                .especialidade(n.getEspecialidade())
                .telefone(n.getTelefone())
                .email(n.getEmail())
                .imagemUrl(n.getImagemUrl())
                .avaliacao(n.getAvaliacao())
                .atendimentosRealizados(n.getAtendimentosRealizados())
                .cidade(cidade)
                .estado(estado)
                .build();
    }
}
