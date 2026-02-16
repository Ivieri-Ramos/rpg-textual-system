package br.com.rpg.controller;

import br.com.rpg.model.entities.Heroi;
import br.com.rpg.model.entities.Inimigo;

public class BatalhaController {

    public void inicarBatalha(Heroi jogador, Inimigo oponente) {
        while (jogador.isVivo() && oponente.isVivo()) {
            // Turno do jogador
            // Turno do inimigo
            // Futuramente aplicar efeitos, como sangramento, queimadura, atordoar, etc.
        }
    }

    private void turnoJogador(Heroi jogador, Inimigo alvo) {
        // Pedir ação do jogador, como defender, atacar, fugir, etc.
        jogador.atacar(alvo, );
    }
}
