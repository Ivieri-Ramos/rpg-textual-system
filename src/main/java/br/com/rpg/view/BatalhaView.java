package br.com.rpg.view;

import br.com.rpg.model.dto.ResultadoAtaque;
import br.com.rpg.model.entities.Habilidade;
import br.com.rpg.model.entities.Heroi;
import br.com.rpg.model.entities.Inimigo;
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
        System.out.println("[5] Veja seus status");
        System.out.println("[6] Fuja");
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
            if (result.defendeu()) {
                imprimir.append("mas ele defendeu, ");
            }
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
        ConsoleUtils.digitarLento(imprimir.toString());
        System.out.println("────────────────────────────────────────");
        System.out.println();
        ConsoleUtils.aguardarSegundos(1);
    }

    /**
     * Imprime uma mensagem no console avisando ao jogador que ele se defendeu.
     */
    public void jogadorDefendeu() {
        System.out.println("────────────────────────────────────────");
        ConsoleUtils.digitarLento("Você armou sua defesa, o próximo ataque causa metade do dano!");
        System.out.println("────────────────────────────────────────");
    }
    public void imprimirInfoInimigo(Inimigo oponente, boolean isPrimeiroTurno) {
        String vidaInimigo = (!isPrimeiroTurno) ? String.valueOf(oponente.getVida()) : "???";
        System.out.println("┌───────────────────────────────────────────┐");
        System.out.printf("│ NOME: %-35s │%n", oponente.getNome());
        System.out.println("├───────────────────────────────────────────┤");
        System.out.printf("│ Vida atual do inimigo: %18s │%n", vidaInimigo);
        if (!isPrimeiroTurno) {
            System.out.printf("│ * Habilidades aprendidas: %16s│%n", " "); // Espaços vazios.
            for (Habilidade habAtual : oponente.getMenuHabilidades()) {
                System.out.printf("│ > %-39s │%n", habAtual.nome());
            }
        }
        System.out.println("└───────────────────────────────────────────┘");
    }
}