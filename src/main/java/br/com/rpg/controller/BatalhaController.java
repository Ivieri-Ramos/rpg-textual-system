package br.com.rpg.controller;

import br.com.rpg.model.entities.Heroi;
import br.com.rpg.model.entities.Inimigo;
import br.com.rpg.view.BatalhaView;
import br.com.rpg.view.ListagemView;
import br.com.rpg.view.Teclado;

/**
 * Classe responsável no controle do fluxo de batalha.
 * <p>
 * Possui métodos estáticos que gerenciam o turno do jogador
 * e do inimigo dentro de {@link BatalhaController#iniciarBatalha(Heroi, Inimigo) iniciarBatalha}.
 */
public class BatalhaController {

    public void iniciarBatalha(Heroi jogador, Inimigo oponente) {
        while (jogador.isVivo() && oponente.isVivo()) {
            // TODO: Turno do jogador
            // TODO: Turno do inimigo
            // TODO: Futuramente aplicar efeitos, como sangramento, queimadura, atordoar, etc.
        }
    }

    private void turnoJogador(Heroi jogador, Inimigo alvo) {
        // TODO: Pedir ação do jogador, como defender, atacar, fugir, etc.
        BatalhaView.mostrarInfoBatalhaJogador(jogador);
        int opEscolhida = Teclado.lerInteiro("Selecione alguma opção acima:", 1, 5);
        switch (opEscolhida) {
            case 1 -> {
                ListagemView.mostrarHabilidades(jogador.getMenuHabilidades(), jogador.getMana());
                int qtdHabilidades = jogador.getMenuHabilidades().size();
                int usarHabilidade = Teclado.lerInteiro("Selecione qual habilidade usar", 1, qtdHabilidades);
                if (jogador.getMenuHabilidades().get(usarHabilidade).custoMana() > jogador.getMana()) {

                }
            }
        }
    }
}
