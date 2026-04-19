package com.projeto.lina.service;

import com.projeto.lina.model.*;
import com.projeto.lina.repository.*;
import com.projeto.lina.mapper.ListaComprasMapper;
import com.projeto.lina.dto.ListaComprasDTO;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ListaComprasService {

    private final PlanoSemanalRepository planoRepository;

    public ListaComprasService(PlanoSemanalRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    public List<ListaComprasDTO> gerarLista(Long usuarioId) {

        PlanoSemanal plano = planoRepository.findByUsuarioId(usuarioId)
                .orElseThrow(() -> new RuntimeException("Plano não encontrado"));

        Map<Ingrediente, Double> totalIngredientes = new HashMap<>();

        for (Cardapio cardapio : plano.getCardapios()) {
            for (ItemCardapio item : cardapio.getItens()) {

                Refeicao refeicao = item.getRefeicao();

                if (refeicao.getIngredientes() == null) continue;

                for (RefeicaoIngrediente ri : refeicao.getIngredientes()) {

                    if (ri.getIngrediente() == null) continue;

                    totalIngredientes.merge(
                            ri.getIngrediente(),
                            ri.getQuantidade(),
                            Double::sum
                    );
                }
            }
        }

        // Agrupar por categoria
        Map<CategoriaIngrediente, Map<String, Double>> agrupado = new HashMap<>();

        for (Map.Entry<Ingrediente, Double> entry : totalIngredientes.entrySet()) {

            Ingrediente ingrediente = entry.getKey();
            Double quantidade = entry.getValue();

            agrupado
                    .computeIfAbsent(ingrediente.getCategoria(), k -> new HashMap<>())
                    .put(ingrediente.getNome(), quantidade);
        }

        return ListaComprasMapper.toDTO(agrupado);
    }
}