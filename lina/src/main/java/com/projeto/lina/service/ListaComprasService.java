package com.projeto.lina.service;

import com.projeto.lina.dto.ListaComprasDTO;
import com.projeto.lina.exception.EntidadeNaoEncontradaException;
import com.projeto.lina.mapper.ListaComprasMapper;
import com.projeto.lina.model.*;
import com.projeto.lina.repository.PlanoSemanalRepository;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ListaComprasService {

    private final PlanoSemanalRepository planoRepository;

    public ListaComprasService(PlanoSemanalRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    public List<ListaComprasDTO> gerarLista(Long usuarioId) {

        PlanoSemanal plano = planoRepository.findByUsuarioIdComItens(usuarioId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Plano não encontrado para este usuário"));

        Map<Ingrediente, Double> totalIngredientes = new HashMap<>();

        for (Cardapio cardapio : plano.getCardapios()) {
            for (ItemCardapio item : cardapio.getItens()) {
                Refeicao refeicao = item.getRefeicao();
                if (refeicao.getIngredientes() == null) continue;
                for (RefeicaoIngrediente ri : refeicao.getIngredientes()) {
                    if (ri.getIngrediente() == null) continue;
                    totalIngredientes.merge(ri.getIngrediente(), ri.getQuantidade(), Double::sum);
                }
            }
        }

        Map<CategoriaIngrediente, Map<String, Double>> agrupado = new HashMap<>();
        for (Map.Entry<Ingrediente, Double> entry : totalIngredientes.entrySet()) {
            Ingrediente ingrediente = entry.getKey();
            agrupado
                    .computeIfAbsent(ingrediente.getCategoria(), k -> new HashMap<>())
                    .put(ingrediente.getNome(), entry.getValue());
        }

        return ListaComprasMapper.toDTO(agrupado);
    }
}
