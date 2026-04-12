package com.projeto.lina.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cardapio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String diaSemana;
    @OneToOne //Quer dizer que usuários não podem ter o mesmo cardápio?
    private Usuario usuario;
    @OneToMany
    private List<Refeicao> refeicoes;
}
