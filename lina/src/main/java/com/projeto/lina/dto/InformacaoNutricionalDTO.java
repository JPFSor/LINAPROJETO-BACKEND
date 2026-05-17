package com.projeto.lina.dto;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InformacaoNutricionalDTO {
    private Integer porcoes;
    private String porcaoLabel;
    private Double calorias;
    private Double proteinaG;
    private Double carboidratosG;
    private Double fibrasG;
    private Double acucaresG;
    private Double gorduraTotalG;
    private Double gorduraSaturadaG;
    private Double gorduraMonoinsaturadaG;
    private Double gorduraPoliinsaturadaG;
    private Double colesterolMg;
    private Double salG;
    private Double sodioMg;
    private Double potassioMg;
}

