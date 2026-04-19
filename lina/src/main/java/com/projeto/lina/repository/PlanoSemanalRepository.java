package com.projeto.lina.repository;

import com.projeto.lina.model.PlanoSemanal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlanoSemanalRepository extends JpaRepository<PlanoSemanal, Long> {
    Optional<PlanoSemanal> findByUsuarioId(Long usuarioId);
}
