package com.projeto.lina.dto;

import com.projeto.lina.model.PeriodoDia;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemCardapioDTO {
    private Long id;
    private PeriodoDia periodo;
    private RefeicaoResponseDTO refeicao;
}
