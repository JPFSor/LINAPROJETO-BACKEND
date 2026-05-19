package com.projeto.lina.service;

import com.projeto.lina.dto.ItemListaDTO;
import com.projeto.lina.dto.ListaComprasDTO;
import com.projeto.lina.exception.EntidadeNaoEncontradaException;
import com.projeto.lina.mapper.ListaComprasMapper;
import com.projeto.lina.model.*;
import com.projeto.lina.repository.PlanoSemanalRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class ListaComprasService {

    private final PlanoSemanalRepository planoRepository;

    public ListaComprasService(PlanoSemanalRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    @Transactional(readOnly = true)
    public List<ListaComprasDTO> gerarLista(Long usuarioId) {

        PlanoSemanal plano = planoRepository.findByUsuarioIdComItens(usuarioId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Plano não encontrado para este usuário"));

        // Conta quantas VEZES cada ingrediente aparece nas refeições da semana
        Map<Long, Double> contagem = new HashMap<>();
        Map<Long, Ingrediente> ingredientes = new HashMap<>();

        for (Cardapio cardapio : plano.getCardapios()) {
            for (ItemCardapio item : cardapio.getItens()) {
                Refeicao refeicao = item.getRefeicao();
                if (refeicao.getIngredientes() == null) continue;
                for (RefeicaoIngrediente ri : refeicao.getIngredientes()) {
                    if (ri.getIngrediente() == null) continue;
                    Long ingId = ri.getIngrediente().getId();
                    ingredientes.putIfAbsent(ingId, ri.getIngrediente());
                    contagem.merge(ingId, 1.0, Double::sum);
                }
            }
        }

        // Agrupa por categoria do ingrediente
        Map<CategoriaIngrediente, List<ItemListaDTO>> agrupado = new HashMap<>();
        for (Map.Entry<Long, Double> entry : contagem.entrySet()) {
            Ingrediente ingrediente = ingredientes.get(entry.getKey());
            CategoriaIngrediente categoria = ingrediente.getCategoria() != null
                    ? ingrediente.getCategoria()
                    : CategoriaIngrediente.OUTROS;

            ItemListaDTO item = ItemListaDTO.builder()
                    .nomeIngrediente(ingrediente.getNome())
                    .quantidade(entry.getValue())
                    .unidade("")
                    .build();

            agrupado.computeIfAbsent(categoria, k -> new ArrayList<>()).add(item);
        }

        return ListaComprasMapper.toDTO(agrupado);
    }
}
