package br.com.rpg.controller;

import br.com.rpg.model.entities.Heroi;
import br.com.rpg.model.entities.Inimigo;

/**
 * Classe responsável no controle do fluxo de batalha.
 * <p>
 * Possui métodos estáticos que gerenciam o turno do jogador
 * e do inimigo dentro de {@link BatalhaController#iniciarBatalha(Heroi, Inimigo) iniciarBatalha}.
 */
public class BatalhaController {

    public void iniciarBatalha(Heroi jogador, Inimigo oponente) {
        while (jogador.isVivo() && oponente.isVivo()) {
            // Turno do jogador
            // Turno do inimigo
            // Futuramente aplicar efeitos, como sangramento, queimadura, atordoar, etc.
        }
    }

    private void turnoJogador(Heroi jogador, Inimigo alvo) {
        // TODO: Pedir ação do jogador, como defender, atacar, fugir, etc.

    }
}
