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

        Map<ChaveConsolidacao, Double> totalIngredientes = new HashMap<>();

        for (Cardapio cardapio : plano.getCardapios()) {
            for (ItemCardapio item : cardapio.getItens()) {
                Refeicao refeicao = item.getRefeicao();
                if (refeicao.getIngredientes() == null) continue;
                for (RefeicaoIngrediente ri : refeicao.getIngredientes()) {
                    if (ri.getIngrediente() == null) continue;
                    String unidade = ri.getUnidade() != null ? ri.getUnidade().trim() : "";
                    ChaveConsolidacao chave = new ChaveConsolidacao(ri.getIngrediente(), unidade);
                    totalIngredientes.merge(chave, ri.getQuantidade(), Double::sum);
                }
            }
        }

        Map<CategoriaIngrediente, List<ItemListaDTO>> agrupado = new HashMap<>();
        for (Map.Entry<ChaveConsolidacao, Double> entry : totalIngredientes.entrySet()) {
            Ingrediente ingrediente = entry.getKey().ingrediente();
            CategoriaIngrediente categoria = ingrediente.getCategoria() != null
                    ? ingrediente.getCategoria()
                    : CategoriaIngrediente.OUTROS;

            ItemListaDTO item = ItemListaDTO.builder()
                    .nomeIngrediente(ingrediente.getNome())
                    .quantidade(entry.getValue())
                    .unidade(entry.getKey().unidade())
                    .build();

            agrupado.computeIfAbsent(categoria, k -> new ArrayList<>()).add(item);
        }

        return ListaComprasMapper.toDTO(agrupado);
    }

    private record ChaveConsolidacao(Ingrediente ingrediente, String unidade) {}
}
