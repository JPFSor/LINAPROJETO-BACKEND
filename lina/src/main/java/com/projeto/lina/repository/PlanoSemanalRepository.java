package com.projeto.lina.repository;

import com.projeto.lina.model.PlanoSemanal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PlanoSemanalRepository extends JpaRepository<PlanoSemanal, Long> {

    Optional<PlanoSemanal> findByUsuarioId(Long usuarioId);

    /**
     * Busca o plano com todos os dados necessários para gerar o cardápio
     * e a lista de compras em uma única query, evitando o problema N+1.
     *
     * Usado por: ListaComprasService, CardapioService
     */
    @Query("""
        SELECT DISTINCT p FROM PlanoSemanal p
        JOIN FETCH p.cardapios c
        JOIN FETCH c.itens i
        JOIN FETCH i.refeicao r
        JOIN FETCH r.ingredientes ri
        JOIN FETCH ri.ingrediente ing
        WHERE p.usuario.id = :usuarioId
    """)
    Optional<PlanoSemanal> findByUsuarioIdComItens(@Param("usuarioId") Long usuarioId);
}
