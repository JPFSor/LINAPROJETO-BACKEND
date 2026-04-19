package com.projeto.lina.dto;

import com.projeto.lina.model.DiaSemana;
import lombok.*;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardapioDTO {
    private Long id;
    private DiaSemana diaSemana;
    private List<ItemCardapioDTO> itens;
}
