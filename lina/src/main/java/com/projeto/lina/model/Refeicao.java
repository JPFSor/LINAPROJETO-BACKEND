package com.projeto.lina.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    // Set em vez de List — evita MultipleBagFetchException no JOIN FETCH
    @OneToMany(mappedBy = "refeicao", cascade = CascadeType.ALL)
    private Set<RefeicaoIngrediente> ingredientes = new LinkedHashSet<>();

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Restricao> restricoes;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<PeriodoDia> periodosPermitidos;

    @OneToMany(mappedBy = "refeicao")
    private Set<ItemCardapio> itensCardapio = new LinkedHashSet<>();
}
