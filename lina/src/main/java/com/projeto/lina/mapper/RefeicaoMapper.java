package com.projeto.lina.mapper;

import com.projeto.lina.dto.*;
import com.projeto.lina.model.*;

import java.util.*;
import java.util.stream.Collectors;

public class RefeicaoMapper {
    private RefeicaoMapper() {}

    public static RefeicaoResponseDTO toDTO(Refeicao r) {
        return toDTO(r, null, false);
    }

    public static RefeicaoResponseDTO toDetalheDTO(Refeicao r, PeriodoDia periodo) {
        return toDTO(r, periodo, true);
    }

    private static RefeicaoResponseDTO toDTO(Refeicao r, PeriodoDia periodo, boolean incluirNutricao) {
        RefeicaoResponseDTO dto = new RefeicaoResponseDTO();

        dto.setId(r.getId());
        dto.setNome(r.getNome());
        dto.setImagemUrl(r.getImagemUrl());
        dto.setCalorias(r.getCalorias());
        dto.setTempoPreparo(r.getTempoPreparo());
        dto.setModoPreparo(r.getModoPreparo());

        List<IngredienteItemDTO> itens = mapearIngredientes(r);
        dto.setIngredientesDetalhados(itens);
        dto.setIngredientes(
                itens.stream()
                        .map(IngredienteItemDTO::getTexto)
                        .collect(Collectors.toList())
        );

        List<Restricao> bloqueios = r.getRestricoes() != null ? r.getRestricoes() : List.of();
        dto.setRestricoes(
                bloqueios.stream()
                        .map(RefeicaoMapper::traduzirRestricao)
                        .collect(Collectors.toList())
        );
        dto.setAdequadoPara(calcularAdequadoPara(bloqueios));

        dto.setPeriodosPermitidos(r.getPeriodosPermitidos());

        if (periodo != null) {
            dto.setPeriodo(periodo);
            dto.setPeriodoLabel(rotuloPeriodo(periodo));
        }

        if (incluirNutricao && r.getInformacaoNutricional() != null) {
            dto.setInformacoesNutricionais(toNutricaoDTO(r.getInformacaoNutricional()));
        }

        return dto;
    }

    private static List<IngredienteItemDTO> mapearIngredientes(Refeicao r) {
        if (r.getIngredientes() == null || r.getIngredientes().isEmpty()) {
            return List.of();
        }
        return r.getIngredientes().stream()
                .sorted(Comparator.comparing(RefeicaoIngrediente::getId, Comparator.nullsLast(Long::compareTo)))
                .map(RefeicaoMapper::toIngredienteItemDTO)
                .collect(Collectors.toList());
    }

    private static IngredienteItemDTO toIngredienteItemDTO(RefeicaoIngrediente ri) {
        Ingrediente ingrediente = ri.getIngrediente();
        String nome = ingrediente != null ? ingrediente.getNome() : "";
        String unidade = ri.getUnidade() != null ? ri.getUnidade().trim() : "";
        double qtd = ri.getQuantidade();
        String categoria = ingrediente != null && ingrediente.getCategoria() != null
                ? ingrediente.getCategoria().name()
                : null;

        return IngredienteItemDTO.builder()
                .quantidade(qtd)
                .unidade(unidade)
                .nome(nome)
                .categoria(categoria)
                .texto(formatarIngrediente(qtd, unidade, nome))
                .build();
    }

    static String formatarIngrediente(double quantidade, String unidade, String nome) {
        String qtdTxt = formatarQuantidade(quantidade);
        String nomeTxt = nome != null ? nome.trim().toLowerCase() : "";

        if (unidade == null || unidade.isBlank()) {
            return qtdTxt + " " + nomeTxt;
        }
        if (unidade.equalsIgnoreCase("pitada") || unidade.equalsIgnoreCase("a gosto")) {
            return unidade + " de " + nomeTxt;
        }
        return qtdTxt + " " + unidade + " de " + nomeTxt;
    }

    private static String formatarQuantidade(double qtd) {
        if (qtd == 0.25) return "1/4";
        if (qtd == 0.5) return "1/2";
        if (qtd == 0.75) return "3/4";
        if (Math.rint(qtd) == qtd) {
            return String.valueOf((long) qtd);
        }
        String s = String.valueOf(qtd).replace('.', ',');
        return s.endsWith(",0") ? s.substring(0, s.length() - 2) : s;
    }

    static List<String> calcularAdequadoPara(List<Restricao> bloqueios) {
        Set<Restricao> bloqueioSet = (bloqueios != null && !bloqueios.isEmpty())
                ? EnumSet.copyOf(bloqueios)
                : EnumSet.noneOf(Restricao.class);

        List<String> tags = new ArrayList<>();
        if (!bloqueioSet.contains(Restricao.CELIACO)) {
            tags.add("Sem Glúten");
        }
        if (!bloqueioSet.contains(Restricao.LACTOSE)) {
            tags.add("Sem Lactose");
        }
        if (!bloqueioSet.contains(Restricao.VEGANO)) {
            tags.add("Vegano");
        }
        if (!bloqueioSet.contains(Restricao.VEGETARIANO)) {
            tags.add("Vegetariano");
        }
        if (!bloqueioSet.contains(Restricao.DIABETICO)) {
            tags.add("Diabético");
        }
        return tags;
    }

    static String rotuloPeriodo(PeriodoDia periodo) {
        return switch (periodo) {
            case CAFE_DA_MANHA -> "Café da Manhã";
            case ALMOCO -> "Almoço";
            case LANCHE_DA_TARDE -> "Lanche da Tarde";
            case JANTAR -> "Jantar";
        };
    }

    private static String traduzirRestricao(Restricao restricao) {
        return switch (restricao) {
            case CELIACO -> "Sem Glúten";
            case LACTOSE -> "Sem Lactose";
            case VEGANO -> "Vegano";
            case VEGETARIANO -> "Vegetariano";
            case DIABETICO -> "Diabético";
            default -> restricao.name();
        };
    }

    private static InformacaoNutricionalDTO toNutricaoDTO(InformacaoNutricional n) {
        return InformacaoNutricionalDTO.builder()
                .porcoes(n.getPorcoes())
                .porcaoLabel(n.getPorcaoLabel())
                .calorias(n.getCalorias())
                .proteinaG(n.getProteinaG())
                .carboidratosG(n.getCarboidratosG())
                .fibrasG(n.getFibrasG())
                .acucaresG(n.getAcucaresG())
                .gorduraTotalG(n.getGorduraTotalG())
                .gorduraSaturadaG(n.getGorduraSaturadaG())
                .gorduraMonoinsaturadaG(n.getGorduraMonoinsaturadaG())
                .gorduraPoliinsaturadaG(n.getGorduraPoliinsaturadaG())
                .colesterolMg(n.getColesterolMg())
                .salG(n.getSalG())
                .sodioMg(n.getSodioMg())
                .potassioMg(n.getPotassioMg())
                .build();
    }
}
