package com.projeto.lina.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private CategoriaIngrediente categoriaIngrediente;
}
