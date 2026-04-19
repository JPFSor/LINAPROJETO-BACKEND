package com.projeto.lina.service;

import com.projeto.lina.dto.UsuarioUpdateDTO;
import com.projeto.lina.model.Usuario;
import com.projeto.lina.dto.UsuarioCreateDTO;
import com.projeto.lina.dto.UsuarioResponseDTO;
import com.projeto.lina.mapper.UsuarioMapper;
import com.projeto.lina.repository.UsuarioRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PlanoSemanalService planoService;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository,
                          PlanoSemanalService planoService,
                          PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.planoService = planoService;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioResponseDTO criarUsuario(UsuarioCreateDTO dto) {

        Usuario usuario = UsuarioMapper.toEntity(dto);

        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));

        usuario = usuarioRepository.save(usuario);

        planoService.criarPlanoParaUsuario(usuario);

        return UsuarioMapper.toDTO(usuario);
    }

    public List<UsuarioResponseDTO> listarUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioMapper::toDTO)
                .toList();
    }

    public UsuarioResponseDTO buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return UsuarioMapper.toDTO(usuario);
    }

    public UsuarioResponseDTO atualizar(Long id, UsuarioUpdateDTO dto) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        UsuarioMapper.updateEntity(usuario, dto);

        usuario = usuarioRepository.save(usuario);

        return UsuarioMapper.toDTO(usuario);
    }
    
    public void deletar(Long id) {

        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado");
        }

        usuarioRepository.deleteById(id);
    }
}