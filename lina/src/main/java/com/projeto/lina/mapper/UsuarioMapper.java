package com.projeto.lina.mapper;

import com.projeto.lina.dto.UsuarioCreateDTO;
import com.projeto.lina.dto.UsuarioUpdateDTO;
import com.projeto.lina.model.Genero;
import com.projeto.lina.model.Restricao;
import com.projeto.lina.model.Usuario;
import com.projeto.lina.dto.UsuarioResponseDTO;

import java.time.LocalDate;
import java.util.List;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioCreateDTO dto) {
        Usuario u = new Usuario();

        u.setNome(dto.getNome());
        u.setEmail(dto.getEmail());
        u.setSenha(dto.getSenha());

        // Converte String "YYYY-MM-DD" para LocalDate para salvar no banco
        if (dto.getDataNascimento() != null && !dto.getDataNascimento().isEmpty()) {
            try {
                u.setDataNascimento(LocalDate.parse(dto.getDataNascimento()));
            } catch (Exception ignored) {
                // Data inválida: ignora sem quebrar o cadastro
            }
        }

        // Salva gênero
        if (dto.getGenero() != null && !dto.getGenero().isEmpty()) {
            try {
                u.setGenero(Genero.valueOf(dto.getGenero().toUpperCase()));
            } catch (IllegalArgumentException ignored) {}
        }

        // Prioridade: lista > restrição única do Android
        if (dto.getRestricoes() != null && !dto.getRestricoes().isEmpty()) {
            u.setRestricoes(
                    dto.getRestricoes().stream().map(Restricao::valueOf).toList()
            );
        } else if (dto.getRestricaoAlimentar() != null && !dto.getRestricaoAlimentar().isEmpty()) {
            try {
                u.setRestricoes(List.of(Restricao.valueOf(dto.getRestricaoAlimentar().toUpperCase())));
            } catch (IllegalArgumentException ignored) {}
        }

        return u;
    }

    public static UsuarioResponseDTO toDTO(Usuario u) {
        UsuarioResponseDTO dto = new UsuarioResponseDTO();

        dto.setId(u.getId());
        dto.setNome(u.getNome());
        dto.setEmail(u.getEmail());
        dto.setAssinante(u.isAssinante());

        // Converte LocalDate de volta para String "YYYY-MM-DD" que o Android lê
        if (u.getDataNascimento() != null) {
            dto.setDataNascimento(u.getDataNascimento().toString());
        }

        if (u.getRestricoes() != null) {
            dto.setRestricoes(
                    u.getRestricoes().stream().map(Enum::name).toList()
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
                    dto.getRestricoes().stream().map(Restricao::valueOf).toList()
            );
        }
    }
}
