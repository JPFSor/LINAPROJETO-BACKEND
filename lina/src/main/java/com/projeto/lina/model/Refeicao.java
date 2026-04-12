package com.projeto.lina.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Refeicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String periodoDia;
    private int tempoPreparo;
    private int valorCalorico;
    private String modoPreparo;
    @OneToMany
    private List<Ingrediente> ingredientes;
    @OneToMany
    private List<Restricao> restricoes;
}
