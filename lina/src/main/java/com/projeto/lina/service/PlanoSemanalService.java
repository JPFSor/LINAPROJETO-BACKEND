package com.projeto.lina.service;

import com.projeto.lina.model.*;
import com.projeto.lina.repository.*;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlanoSemanalService {

    private final PlanoSemanalRepository planoRepository;

    public PlanoSemanalService(PlanoSemanalRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    public PlanoSemanal criarPlanoParaUsuario(Usuario usuario) {

        PlanoSemanal plano = new PlanoSemanal();
        plano.setUsuario(usuario);

        List<Cardapio> cardapios = new ArrayList<>();

        for (DiaSemana dia : DiaSemana.values()) {

            Cardapio cardapio = new Cardapio();
            cardapio.setDiaSemana(dia);
            cardapio.setPlanoSemanal(plano);
            cardapio.setItens(new ArrayList<>());

            cardapios.add(cardapio);
        }

        plano.setCardapios(cardapios);

        return planoRepository.save(plano);
    }
}