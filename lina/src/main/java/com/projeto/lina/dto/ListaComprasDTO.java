package com.projeto.lina.dto;

import com.projeto.lina.model.CategoriaIngrediente;
import lombok.*;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListaComprasDTO {
    private CategoriaIngrediente categoria;
    private List<ItemListaDTO> itens;
}
