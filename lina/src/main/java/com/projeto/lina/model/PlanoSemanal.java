package com.projeto.lina.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class PlanoSemanal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    @OneToMany(mappedBy = "planoSemanal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cardapio> cardapios;
}
