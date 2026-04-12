package com.projeto.lina.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Date dataNascimento;
    private String email;
    private String senha;
    private boolean assinante; //Criar model próprio?
    @OneToMany
    private List<Restricao> restricoes;
    @ManyToOne
    private Endereco endereco;
    @OneToOne //Quer dizer que usuários não podem ter o mesmo cardápio?
    private Cardapio cardapio;
}
