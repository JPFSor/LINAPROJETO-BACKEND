package com.projeto.lina.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Refeicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer tempoPreparo;
    private double calorias;
    @Column(length = 2000)
    private String modoPreparo;
    private String imagemUrl;
    @OneToMany(mappedBy = "refeicao", cascade = CascadeType.ALL)
    private List<RefeicaoIngrediente> ingredientes;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Restricao> restricoes;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<PeriodoDia> periodosPermitidos;
    // opcional (navegação reversa)
    @OneToMany(mappedBy = "refeicao")
    private List<ItemCardapio> itensCardapio;
}