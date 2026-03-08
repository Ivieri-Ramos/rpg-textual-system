package br.com.rpg.view;

import br.com.rpg.model.dto.ResultadoBatalha;
import br.com.rpg.model.enums.DesfechoBatalha;
import br.com.rpg.view.utils.ConsoleUtils;

public class MasmorraView {

    /**
     * Imprime o resultado da batalha ao usuário.
     * @param result DTO que representa o resultado da batalha.
     */
    public void imprimirResultadoBatalha(ResultadoBatalha result) {
        DesfechoBatalha resultado = result.resultado();
        String nomeInimigo = result.nomeInimigo();
        switch (resultado) {
            case HEROI_VENCEU -> ConsoleUtils.imprimirCaixaDialogo("Parabéns! você ganhou de " + nomeInimigo);
            case HEROI_FUGIU -> ConsoleUtils.imprimirCaixaDialogo("Covarde! você fugiu de " + nomeInimigo);
            case HEROI_MORREU -> ConsoleUtils.imprimirCaixaDialogo("Que peninha, pelo jeito alguém aqui perdeu para " + nomeInimigo);
        }
    }

    /**
     * Imprime avisando qual inimigo o jogador irá enfrentar.
     * @param nomeInimigo O nome do inimigo que será impresso.
     */
    public void imprimirMensagemInicioBatalha(String nomeInimigo) {
        ConsoleUtils.imprimirCaixaDialogo("Você encontrou " + nomeInimigo + " prepare-se para um luta árdua!");
    }
}
