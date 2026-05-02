package com.projeto.lina.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class NutricionistaResponseDTO {

    private Long id;
    private String nome;
    private String especialidade;
    private String telefone;
    private String email;
    private String imagemUrl;
    private double avaliacao;
    private int atendimentosRealizados;

    // Endereço desnormalizado para a tela (ex: "Sorocaba, SP")
    private String cidade;
    private String estado;
}
