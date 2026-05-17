package com.projeto.lina.mapper;

import com.projeto.lina.model.*;
import com.projeto.lina.dto.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListaComprasMapper {
    private ListaComprasMapper() {}

    public static List<ListaComprasDTO> toDTO(
            Map<CategoriaIngrediente, List<ItemListaDTO>> dados) {

        List<ListaComprasDTO> lista = new ArrayList<>();

        for (CategoriaIngrediente categoria : CategoriaIngrediente.values()) {
            List<ItemListaDTO> itens = dados.get(categoria);
            if (itens == null || itens.isEmpty()) {
                continue;
            }
            ListaComprasDTO dto = new ListaComprasDTO();
            dto.setCategoria(categoria);
            dto.setItens(new ArrayList<>(itens));
            lista.add(dto);
        }

        return lista;
    }
}
