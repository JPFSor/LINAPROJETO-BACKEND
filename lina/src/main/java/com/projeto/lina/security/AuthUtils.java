package com.projeto.lina.security;

import com.projeto.lina.model.Usuario;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthUtils {

    private AuthUtils() {}

    public static Usuario getUsuarioAutenticado() {
        return (Usuario) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
    }

    public static void verificarProprietario(Long usuarioId) {
        Usuario autenticado = getUsuarioAutenticado();
        if (!autenticado.getId().equals(usuarioId)) {
            throw new AccessDeniedException("Acesso negado");
        }
    }
}