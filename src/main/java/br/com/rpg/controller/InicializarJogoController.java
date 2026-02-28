package br.com.rpg.controller;

import br.com.rpg.model.entities.heroi.CatalogoHeroi;
import br.com.rpg.model.entities.heroi.Heroi;
import br.com.rpg.model.mundo.Cidade;
import br.com.rpg.model.mundo.MundoBuilder;
import br.com.rpg.model.services.SaveService;
import br.com.rpg.view.Teclado;

public class InicializarJogoController {
    private final SaveService salvador = new SaveService();
    private final MundoBuilder construtor = new MundoBuilder();
    private final Teclado input = new Teclado();

    public void iniciarJogo() {
        Cidade cidadeJogo = construtor.gerarCidadePrincipal();
        Heroi jogador;
        if ((jogador = salvador.carregarJogo()) == null) {
            // Se tentar inicializar um jogador a partir de um save e ele não existir, cria um novo herói.

            String nomeJogador = input.lerNomeJogador();
            int classeJogador = input.lerInteiro("Escolha a sua classe: ", 1, 2);
            switch (classeJogador) {
                case 1 -> jogador = CatalogoHeroi.enviarHeroi("GUERREIRO", nomeJogador);
                case 2 -> jogador = CatalogoHeroi.enviarHeroi("MAGO", nomeJogador);
            }
        }
        ExploracaoController jogo = new ExploracaoController(cidadeJogo);
        jogo.centroJogo(jogador);
    }
}
