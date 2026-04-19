package com.projeto.lina.mapper;

import com.projeto.lina.model.*;
import com.projeto.lina.dto.RefeicaoResponseDTO;
import lombok.*;

import java.util.stream.Collectors;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RefeicaoMapper {

    public static RefeicaoResponseDTO toDTO(Refeicao r) {
        RefeicaoResponseDTO dto = new RefeicaoResponseDTO();

        dto.setId(r.getId());
        dto.setNome(r.getNome());
        dto.setImagemUrl(r.getImagemUrl());
        dto.setCalorias(r.getCalorias());
        dto.setTempoPreparo(r.getTempoPreparo());

        dto.setIngredientes(
                r.getIngredientes()
                        .stream()
                        .map(ri -> ri.getIngrediente().getNome())
                        .collect(Collectors.toList())
        );

        dto.setRestricoes(
                r.getRestricoes()
                        .stream()
                        .map(Enum::name)
                        .collect(Collectors.toList())
        );

        dto.setPeriodosPermitidos(r.getPeriodosPermitidos());

        return dto;
    }
}
