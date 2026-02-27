package br.com.rpg.view;

import br.com.rpg.model.dto.ResultadoBatalha;
import br.com.rpg.model.enums.DesfechoBatalha;
import br.com.rpg.view.utils.ConsoleUtils;

public class MasmorraView {

    public void imprimirResultadoBatalha(ResultadoBatalha result) {
        DesfechoBatalha resultado = result.resultado();
        String nomeInimigo = result.nomeInimigo();
        switch (resultado) {
            case HEROI_VENCEU -> ConsoleUtils.imprimirCaixaDialogo("Parabéns! você ganhou de " + nomeInimigo);
            case HEROI_FUGIU -> ConsoleUtils.imprimirCaixaDialogo("Covarde! você fugiu de " + nomeInimigo);
            case HEROI_MORREU -> ConsoleUtils.imprimirCaixaDialogo("Que peninha, pelo jeito alguém aqui perdeu para " + nomeInimigo);
        }
    }

    public void imprimirMensagemInicioBatalha(String nomeInimigo) {
        ConsoleUtils.imprimirCaixaDialogo("Você encontrou " + nomeInimigo + " prepare-se para um luta árdua!");
    }
}
