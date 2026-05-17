package com.projeto.lina.dto;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IngredienteItemDTO {
    private Double quantidade;
    private String unidade;
    private String nome;
    /** Texto pronto para exibição, ex.: "2 unidades de ovos". */
    private String texto;
}
