package com.projeto.lina.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RefeicaoIngrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Refeicao refeicao;
    @ManyToOne
    private Ingrediente ingrediente;
    private double quantidade;
    private String unidade; // ex: "g", "ml", "unidades"
}
