package com.projeto.lina.mapper;

import com.projeto.lina.model.Usuario;
import com.projeto.lina.dto.UsuarioResponseDTO;

import java.util.stream.Collectors;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioMapper {

    public static UsuarioResponseDTO toDTO(Usuario u) {
        UsuarioResponseDTO dto = new UsuarioResponseDTO();

        dto.setId(u.getId());
        dto.setNome(u.getNome());
        dto.setEmail(u.getEmail());

        dto.setRestricoes(
                u.getRestricoes()
                        .stream()
                        .map(Enum::name)
                        .collect(Collectors.toList())
        );

        return dto;
    }
}