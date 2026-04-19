package com.projeto.lina.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Date dataNascimento;
    @Column(unique = true, nullable = false)
    private String email;
    private String senha;
    private String genero;
    private boolean assinante;
    private String imagemUrl;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Restricao> restricoes;
    @ManyToOne
    private Endereco endereco;
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private PlanoSemanal planoSemanal;
}
