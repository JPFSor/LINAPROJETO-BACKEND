package com.projeto.lina.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "refeicao_informacao_nutricional")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InformacaoNutricional {

    @Id
    @Column(name = "refeicao_id")
    private Long refeicaoId;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "refeicao_id")
    private Refeicao refeicao;

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
