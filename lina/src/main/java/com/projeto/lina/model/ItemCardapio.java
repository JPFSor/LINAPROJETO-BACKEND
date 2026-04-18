package com.projeto.lina.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"cardapio_id", "periodo", "refeicao_id"}
        )
)
public class ItemCardapio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cardapio_id", nullable = false)
    private Cardapio cardapio;
    @ManyToOne
    @JoinColumn(name = "refeicao_id", nullable = false)
    private Refeicao refeicao;
    @Enumerated(EnumType.STRING)
    private PeriodoDia periodoDia;
}
