package com.projeto.lina.mapper;

import com.projeto.lina.model.*;
import com.projeto.lina.dto.*;
import lombok.*;

import java.util.stream.Collectors;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardapioMapper {

    public static CardapioDTO toDTO(Cardapio c) {
        CardapioDTO dto = new CardapioDTO();

        dto.setId(c.getId());
        dto.setDiaSemana(c.getDiaSemana());

        dto.setItens(
                c.getItens()
                        .stream()
                        .map(CardapioMapper::toItemDTO)
                        .collect(Collectors.toList())
        );

        return dto;
    }

    private static ItemCardapioDTO toItemDTO(ItemCardapio item) {
        ItemCardapioDTO dto = new ItemCardapioDTO();

        dto.setId(item.getId());
        dto.setPeriodo(item.getPeriodo());

        dto.setRefeicao(
                RefeicaoMapper.toDTO(item.getRefeicao())
        );

        return dto;
    }
}