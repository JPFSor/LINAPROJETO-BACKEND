package com.projeto.lina.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    // Set em vez de List — evita MultipleBagFetchException no JOIN FETCH
    @OneToMany(mappedBy = "cardapio", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ItemCardapio> itens = new LinkedHashSet<>();
}
