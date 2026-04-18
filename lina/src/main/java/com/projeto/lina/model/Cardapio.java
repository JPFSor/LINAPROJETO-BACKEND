package com.projeto.lina.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"plano_semanal_id", "diaSemana"}
        )
)
public class Cardapio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private DiaSemana diaSemana;
    @ManyToOne
    @JoinColumn(name = "plano_semanal_id")
    private PlanoSemanal planoSemanal;
    @OneToMany(mappedBy = "cardapio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemCardapio> itens;
}
