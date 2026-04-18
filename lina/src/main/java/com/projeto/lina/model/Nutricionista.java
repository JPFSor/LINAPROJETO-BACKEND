package com.projeto.lina.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Nutricionista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crn;
    private String telefone;
    private String especialidade;
    private double avaliacao;
    private int atendimentosRealizados;
    @ManyToOne
    private Endereco endereco;
}
