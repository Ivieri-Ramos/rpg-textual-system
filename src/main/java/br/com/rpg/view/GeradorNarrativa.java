package br.com.rpg.view;

import br.com.rpg.model.dto.ResultadoTurno;
import br.com.rpg.model.services.results.CalculoDano;

public final class GeradorNarrativa {

    private GeradorNarrativa() {}

    public static String traduzirResultadoTurno(ResultadoTurno result) {
        StringBuilder imprimir = new StringBuilder();
        CalculoDano relatorioDano = result.relatorio().relatorioDano();
        imprimir.append(result.nomeAtacante())
                .append(" usou ")
                .append(result.relatorio().nomeHab()); // Cria a frase comum a todas as habilidades
        if (relatorioDano != null) { // Quando é usado habilidades ofensivas ou híbridas
            imprimir.append(" contra ")
                    .append(result.nomeAlvo())
                    .append(" ");
            if (relatorioDano.esquivou()) {
                imprimir.append("mas ele esquivou");
            } else {
                if (relatorioDano.defendeu()) {
                    imprimir.append("mas ele defendeu, ");
                }
                imprimir.append("causando ")
                        .append(relatorioDano.danoFinal())
                        .append(" de dano");
                if (relatorioDano.critico()) {
                    imprimir.append(" e ainda deu crítico");
                }
            }
        }

        if (result.relatorio().deltaVidaRecebida() > 0) { // Se for maior que zero, é porque o atacante se curou
            imprimir.append(", curando ")
                    .append(result.relatorio().deltaVidaRecebida())
                    .append(" de vida no processo");
        }

        if (result.alvoMorreu()) { // Se o alvo morreu, imprime, do contrário, termina com '!'.
            imprimir.append(", matando seu oponente!");
        }
        else {
            imprimir.append("!");
        }
        return imprimir.toString();
    }
}
