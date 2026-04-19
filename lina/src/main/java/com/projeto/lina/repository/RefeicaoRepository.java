package com.projeto.lina.repository;

import com.projeto.lina.model.PeriodoDia;
import com.projeto.lina.model.Refeicao;
import com.projeto.lina.model.Restricao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RefeicaoRepository extends JpaRepository<Refeicao, Long> {
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
