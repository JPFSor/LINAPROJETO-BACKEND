package com.projeto.lina.dto;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemListaDTO {
    private String nomeIngrediente;
    private Double quantidade;
    private String unidade;
}
