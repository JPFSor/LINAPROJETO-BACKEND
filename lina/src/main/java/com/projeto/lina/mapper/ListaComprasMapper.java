package com.projeto.lina.mapper;

import com.projeto.lina.model.*;
import com.projeto.lina.dto.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListaComprasMapper {
    private ListaComprasMapper() {}

    public static List<ListaComprasDTO> toDTO(
            Map<CategoriaIngrediente, Map<String, Double>> dados) {

        List<ListaComprasDTO> lista = new ArrayList<>();

        for (CategoriaIngrediente categoria : dados.keySet()) {

            ListaComprasDTO dto = new ListaComprasDTO();
            dto.setCategoria(categoria);

            List<ItemListaDTO> itens = new ArrayList<>();

            for (Map.Entry<String, Double> entry : dados.get(categoria).entrySet()) {

                ItemListaDTO item = new ItemListaDTO();
                item.setNomeIngrediente(entry.getKey());
                item.setQuantidade(entry.getValue());

                itens.add(item);
            }

            dto.setItens(itens);
            lista.add(dto);
        }

        return lista;
    }
}