package com.projeto.lina.repository;

import com.projeto.lina.model.PeriodoDia;
import com.projeto.lina.model.Refeicao;
import com.projeto.lina.model.Restricao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RefeicaoRepository extends JpaRepository<Refeicao, Long> {

    @Query("""
    SELECT DISTINCT r FROM Refeicao r
    LEFT JOIN FETCH r.ingredientes ri
    LEFT JOIN FETCH ri.ingrediente
    LEFT JOIN FETCH r.informacaoNutricional
    WHERE r.id = :id
    """)
    Optional<Refeicao> findDetalheById(@Param("id") Long id);

    @Query("""
    SELECT r FROM Refeicao r
    WHERE :periodo MEMBER OF r.periodosPermitidos
    AND NOT EXISTS (
        SELECT res FROM r.restricoes res
        WHERE res IN :restricoesUsuario
    )
    """)
    List<Refeicao> buscarValidas(
            @Param("periodo") PeriodoDia periodo,
            @Param("restricoesUsuario") List<Restricao> restricoesUsuario
    );

    @Query("SELECT r FROM Refeicao r WHERE :periodo MEMBER OF r.periodosPermitidos")
    List<Refeicao> findByPeriodo(PeriodoDia periodo);
}

