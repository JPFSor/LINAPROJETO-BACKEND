package com.projeto.lina.mapper;

import com.projeto.lina.dto.UsuarioCreateDTO;
import com.projeto.lina.dto.UsuarioUpdateDTO;
import com.projeto.lina.model.Genero;
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

        // Salva data de nascimento
        if (dto.getDataNascimento() != null) {
            u.setDataNascimento(dto.getDataNascimento());
        }

        // Salva gênero (Android envia String, model espera enum Genero)
        if (dto.getGenero() != null && !dto.getGenero().isEmpty()) {
            try {
                u.setGenero(Genero.valueOf(dto.getGenero().toUpperCase()));
            } catch (IllegalArgumentException ignored) {
                // Gênero inválido: ignora sem quebrar o cadastro
            }
        }

        // Prioridade: lista de restrições > restrição única do Android
        if (dto.getRestricoes() != null && !dto.getRestricoes().isEmpty()) {
            u.setRestricoes(
                    dto.getRestricoes()
                            .stream()
                            .map(Restricao::valueOf)
                            .toList()
            );
        } else if (dto.getRestricaoAlimentar() != null && !dto.getRestricaoAlimentar().isEmpty()) {
            try {
                u.setRestricoes(List.of(Restricao.valueOf(dto.getRestricaoAlimentar().toUpperCase())));
            } catch (IllegalArgumentException ignored) {
                // Restrição inválida: ignora sem quebrar o cadastro
            }
        }

        return u;
    }

    public static UsuarioResponseDTO toDTO(Usuario u) {
        UsuarioResponseDTO dto = new UsuarioResponseDTO();

        dto.setId(u.getId());
        dto.setNome(u.getNome());
        dto.setEmail(u.getEmail());

        dto.setDataNascimento(u.getDataNascimento());
        dto.setAssinante(u.isAssinante());

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
