package com.projeto.lina.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class AssinaturaResponseDTO {

    private Long usuarioId;
    private boolean assinante;
    private LocalDate dataInicio;
    private LocalDate dataRenovacao; // dataInicio + 30 dias
    private String mensagem;
}
