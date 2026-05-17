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
    private String modoPreparo;

    private PeriodoDia periodo;
    private String periodoLabel;

    private List<String> ingredientes;
    private List<IngredienteItemDTO> ingredientesDetalhados;

    private List<String> restricoes;
    private List<String> adequadoPara;

    private List<PeriodoDia> periodosPermitidos;
    private InformacaoNutricionalDTO informacoesNutricionais;
}
