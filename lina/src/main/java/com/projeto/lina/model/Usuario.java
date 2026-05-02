package com.projeto.lina.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    // Trocado de java.util.Date para LocalDate (mais seguro com JPA/PostgreSQL)
    private LocalDate dataNascimento;

    @Column(unique = true, nullable = false)
    private String email;

    private String senha;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    private boolean assinante;

    // Campos de controle da assinatura
    private LocalDate dataInicioAssinatura;
    private LocalDate dataRenovacaoAssinatura;

    private String imagemUrl;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Restricao> restricoes;

    @ManyToOne
    private Endereco endereco;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private PlanoSemanal planoSemanal;
}
