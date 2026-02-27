package br.com.rpg.controller;

import br.com.rpg.model.entities.Heroi;
import br.com.rpg.model.mundo.Cidade;
import br.com.rpg.view.ExploracaoView;
import br.com.rpg.view.Teclado;

/**
 * Comanda o fluxo principal do jogo, é ela que chama outras classes
 * do tipo controller que comandam o resto do fluxo do jogo.
 */
public class ExploracaoController {
    private final ExploracaoView viewExploracao = new ExploracaoView();
    private final Teclado input = new Teclado();
    private final Cidade cidadeAtual;

    public ExploracaoController(Cidade cidadeAtual) {
        this.cidadeAtual = cidadeAtual;
    }

    /**
     * Método principal do jogo, ele que delega para todos os outros controllers,
     * ou seja, ele que comanda o fluxo do jogo
     * @param jogador O usuário que irá agir dentre os outros métodos.
     */
    public void centroJogo(Heroi jogador) {
        while (true) {
            viewExploracao.imprimirMenuCidade(this.cidadeAtual);
            int escolha = input.lerInteiro("Opção: ", 1, 6);
            switch (escolha) {
                case 1 -> { // Joga a primeira masmorra
                    MasmorraController masmorraAtual = new MasmorraController();
                    masmorraAtual.jogarMasmorra(this.cidadeAtual.getMasmorrasProximas().getFirst(), jogador);
                }
                case 2 -> {
                    MasmorraController masmorraAtual = new MasmorraController();
                    masmorraAtual.jogarMasmorra(this.cidadeAtual.getMasmorrasProximas().get(1), jogador);
                }
                case 3 -> {
                    MasmorraController masmorraAtual = new MasmorraController();
                    masmorraAtual.jogarMasmorra(this.cidadeAtual.getMasmorrasProximas().get(2), jogador);
                }
                case 4 -> {
                    MasmorraController masmorraAtual = new MasmorraController();
                    masmorraAtual.jogarMasmorra(this.cidadeAtual.getMasmorrasProximas().get(3), jogador);
                }
                case 5 -> {} // Sistema de salvamento
                case 6 -> { // Sistema de salvamento e sair
                    return;
                }
            }
        }
    }
}
