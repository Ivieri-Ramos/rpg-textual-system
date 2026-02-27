package br.com.rpg.controller;

import br.com.rpg.model.dto.ResultadoBatalha;
import br.com.rpg.model.entities.Heroi;
import br.com.rpg.model.entities.inimigo.Inimigo;
import br.com.rpg.model.mundo.Masmorra;
import br.com.rpg.view.MasmorraView;
import br.com.rpg.view.utils.ConsoleUtils;

public class MasmorraController {
    private final MasmorraView viewPrincipal = new MasmorraView();

    /**
     * Inicia a masmorra, começando da primeira camada, até que o jogador chegue na última.
     * @param jogador A entidade controlada pelo usuário.
     */
    public void jogarMasmorra(Masmorra masmorraAtual, Heroi jogador) {
        BatalhaController batalha = new BatalhaController();
        for (int andarAtual = 1; andarAtual <= masmorraAtual.getTotalAndares(); andarAtual++) {
            Inimigo novoInimigo = masmorraAtual.gerarInimigo(andarAtual);
            viewPrincipal.imprimirMensagemInicioBatalha(novoInimigo.getNome());
            ConsoleUtils.aguardarSegundos(1);
            ResultadoBatalha result = batalha.iniciarBatalha(jogador, novoInimigo);
            viewPrincipal.imprimirResultadoBatalha(result);
        }
    }
}
