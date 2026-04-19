package com.projeto.lina.dto;

import com.projeto.lina.model.PeriodoDia;
import lombok.*;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefeicaoResponseDTO {
    private Long id;
    private String nome;
    private String imagemUrl;
    private Double calorias;
    private Integer tempoPreparo;
    private List<String> ingredientes;
    private List<String> restricoes;
    private List<PeriodoDia> periodosPermitidos;
}
