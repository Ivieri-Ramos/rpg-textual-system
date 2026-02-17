package br.com.rpg.controller;

import br.com.rpg.model.entities.Habilidade;
import br.com.rpg.model.entities.Heroi;
import br.com.rpg.model.entities.Inimigo;
import br.com.rpg.view.BatalhaView;
import br.com.rpg.view.ListagemView;
import br.com.rpg.view.MensagemView;
import br.com.rpg.view.Teclado;

/**
 * Classe responsável no controle do fluxo de batalha.
 * <p>
 * Possui métodos estáticos que gerenciam o turno do jogador
 * e do inimigo dentro de {@link BatalhaController#iniciarBatalha(Heroi, Inimigo) iniciarBatalha}.
 */
public class BatalhaController {

    private final BatalhaView batalhaView = new BatalhaView();
    private final MensagemView avisoView = new MensagemView();
    private final ListagemView listaView = new ListagemView();
    private final Teclado input = new Teclado();

    public void iniciarBatalha(Heroi jogador, Inimigo oponente) {
        while (jogador.isVivo() && oponente.isVivo()) {
            // TODO: Turno do jogador
            // TODO: Turno do inimigo
            // TODO: Futuramente aplicar efeitos, como sangramento, queimadura, atordoar, etc.
        }
    }

    private void turnoJogador(Heroi jogador, Inimigo alvo) {
        // TODO: Pedir ação do jogador, como defender, atacar, fugir, etc.
        while (true) {
            batalhaView.mostrarInfoBatalhaJogador(jogador);
            int opEscolhida = input.lerInteiro("Selecione alguma opção acima:", 1, 5);
            switch (opEscolhida) {
                case 1 -> {
                    Habilidade habUsar = retornarHabilidade(jogador);
                    if (habUsar == null) {
                        continue;
                    }

                }
                case 2 -> {

                }
            }
        }
    }

    private Habilidade retornarHabilidade(Heroi jogador) {
        int qtdHabilidades = jogador.getMenuHabilidades().size();
        while (true) {
            listaView.mostrarHabilidades(jogador.getMenuHabilidades(), jogador.getMana());
            int usarHabilidade = input.lerInteiro("Selecione qual habilidade usar, ou digite 0 para voltar: ", 0, qtdHabilidades);
            if (jogador.getMenuHabilidades().get(usarHabilidade).custoMana() > jogador.getMana()) { // Se não tiver mana suficiente, cancela o uso da habilidade.
                avisoView.mostrarMensagemErro("Você não possui mana para usar essa habilidade!");
                continue;
            }
            if (usarHabilidade == 0) {
                return null;
            }
            return jogador.getMenuHabilidades().get((usarHabilidade - 1)); // Menos um pois está acessando o índice de um vetor.
        }
    }
}
