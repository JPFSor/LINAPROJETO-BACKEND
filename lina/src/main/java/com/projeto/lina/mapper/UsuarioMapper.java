package com.projeto.lina.mapper;

import com.projeto.lina.dto.UsuarioCreateDTO;
import com.projeto.lina.dto.UsuarioUpdateDTO;
import com.projeto.lina.model.Restricao;
import com.projeto.lina.model.Usuario;
import com.projeto.lina.dto.UsuarioResponseDTO;

import java.util.stream.Collectors;

import lombok.*;

import java.util.List;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioCreateDTO dto) {
        Usuario u = new Usuario();

        u.setNome(dto.getNome());
        u.setEmail(dto.getEmail());
        u.setSenha(dto.getSenha());

        if (dto.getRestricoes() != null) {
            u.setRestricoes(
                    dto.getRestricoes()
                            .stream()
                            .map(Restricao::valueOf)
                            .toList()
            );
        }

        return u;
    }

    public static UsuarioResponseDTO toDTO(Usuario u) {
        UsuarioResponseDTO dto = new UsuarioResponseDTO();

        dto.setId(u.getId());
        dto.setNome(u.getNome());
        dto.setEmail(u.getEmail());

        if (u.getRestricoes() != null) {
            dto.setRestricoes(
                    u.getRestricoes()
                            .stream()
                            .map(Enum::name)
                            .toList()
            );
        }

        return dto;
    }

    public static void updateEntity(Usuario usuario, UsuarioUpdateDTO dto) {

        if (dto.getNome() != null)
            usuario.setNome(dto.getNome());

        if (dto.getEmail() != null)
            usuario.setEmail(dto.getEmail());

        if (dto.getRestricoes() != null) {
            usuario.setRestricoes(
                    dto.getRestricoes()
                            .stream()
                            .map(Restricao::valueOf)
                            .toList()
            );
        }
    }
}