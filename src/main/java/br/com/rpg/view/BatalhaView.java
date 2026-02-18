package br.com.rpg.view;

import br.com.rpg.model.dto.ResultadoAtaque;
import br.com.rpg.model.entities.Heroi;
import br.com.rpg.view.utils.ConsoleUtils;

/**
 * Possui métodos usados unicamente para a impressão de informações em batalha
 * necessárias para que o jogador consiga jogar, imprimindo informações do mesmo,
 * ações disponíveis, etc.
 */
public class BatalhaView {

    /**
     * Método que imprime todas as informações contidas no {@link Heroi}.
     * @param jogador Entidade que será imprimida.
     */
    public void mostrarInfoCompletaHeroi(Heroi jogador) {
        String formato = "│ %-25s %15s │%n";
        System.out.println("┌───────────────────────────────────────────┐");
        System.out.printf("│ NOME: %-35s │%n", jogador.getNome());
        System.out.println("├───────────────────────────────────────────┤");
        System.out.printf(formato, "Sua vida total:", jogador.getVida());
        System.out.printf(formato, "Sua mana total:", jogador.getMana());
        System.out.printf(formato, "Seu dano base:", jogador.getDano());
        System.out.printf(formato, "Sua defesa total:", jogador.getDefesa() + "%");
        System.out.printf(formato, "Sua chance de crítico:", jogador.getChanceCrit() + "%");
        System.out.printf(formato, "Sua chance de esquiva:", jogador.getChanceEsq() + "%");
        System.out.println("└───────────────────────────────────────────┘");
    }

    /**
     * Imprime um menu para que o usuário veja as ações que ele pode realizar durante o combate.
     */
    public void mostrarOpcoesBatalhaJogador() {
        System.out.println("[1] Use uma habilidade aprendida");
        System.out.println("[2] Defenda-se");
        System.out.println("[3] Use algum item");
        System.out.println("[4] Analise seu inimigo");
        System.out.println("[5] Fuja");
    }

    /**
     * Imprime um {@link ResultadoAtaque} no terminal usando {@link StringBuilder}.
     * @param result Informação a ser impressa.
     */
    public void mostrarResultadoAtaque(ResultadoAtaque result) {
        StringBuilder imprimir = new StringBuilder();
        imprimir.append(result.nomeAtacante());
        imprimir.append(" usou ");
        imprimir.append(result.nomeHabilidade());
        imprimir.append(" contra ");
        imprimir.append(result.nomeAlvo());
        imprimir.append(" ");
        if (result.esquivou()) {
            imprimir.append("mas ele esquivou.");
        }
        else {
            imprimir.append("causando ");
            imprimir.append(result.danoCausado());
            imprimir.append(" de dano");
            if (result.critico()) {
                imprimir.append(" e ainda deu crítico");
            }
            if (result.alvoMorreu()) {
                imprimir.append(" matando-o!");
            }
            else {
                imprimir.append("!");
            }
        }
        System.out.println();
        System.out.println("────────────────────────────────────────");
        System.out.println(imprimir);
        System.out.println("────────────────────────────────────────");
        System.out.println();
        ConsoleUtils.aguardarSegundos(2);
    }
}
