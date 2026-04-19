package com.projeto.lina.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioCreateDTO {

    private String nome;
    private String email;
    private String senha;
    private List<String> restricoes;
}