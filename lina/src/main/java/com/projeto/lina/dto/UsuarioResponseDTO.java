package com.projeto.lina.dto;

import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponseDTO {
    private Long id;
    private String nome;
    private String email;
    private List<String> restricoes;
    private LocalDate dataNascimento;
    private boolean assinante;
}
