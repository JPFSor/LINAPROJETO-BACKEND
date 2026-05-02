package com.projeto.lina.repository;

import com.projeto.lina.model.Nutricionista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NutricionistaRepository extends JpaRepository<Nutricionista, Long> {

    // Filtro por cidade (case-insensitive, parcial)
    // ex: "Sorocaba" → busca em endereco.cidade
    @Query("""
        SELECT n FROM Nutricionista n
        WHERE LOWER(n.endereco.cidade) LIKE LOWER(CONCAT('%', :cidade, '%'))
        ORDER BY n.avaliacao DESC
    """)
    List<Nutricionista> findByCidade(@Param("cidade") String cidade);

    // Todos, ordenados por avaliação
    @Query("SELECT n FROM Nutricionista n ORDER BY n.avaliacao DESC")
    List<Nutricionista> findAllOrdenadosPorAvaliacao();
}
