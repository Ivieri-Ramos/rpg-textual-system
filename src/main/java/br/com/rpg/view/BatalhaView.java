package br.com.rpg.view;

import br.com.rpg.model.dto.RelatorioInfoInimigo;
import br.com.rpg.model.dto.ResultadoTurno;
import br.com.rpg.model.entities.Heroi;
import br.com.rpg.model.entities.inimigo.Inimigo;
import br.com.rpg.model.services.results.CalculoDano;
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
     * Imprime um {@link ResultadoTurno} no terminal usando {@link StringBuilder}.
     * @param result Informação a ser impressa.
     */
    public void mostrarResultadoTurno(ResultadoTurno result) {
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
        imprimirCaixaDialogo(imprimir.toString());
    }

    /**
     * Imprime uma mensagem no console avisando ao jogador que ele se defendeu.
     */
    public void jogadorDefendeu() {
        imprimirCaixaDialogo("Você armou sua defesa, o próximo ataque causa metade do dano!");
    }

    /**
     * Imprime no terminal o status atual de certos atributos do {@link Inimigo},
     * usando {@link RelatorioInfoInimigo} que armazena as informações a serem reveladas.
     * @param imprimir Informações a serem impressas.
     */
    public void imprimirInfoInimigo(RelatorioInfoInimigo imprimir) {
        System.out.println("┌───────────────────────────────────────────┐");
        System.out.printf("│ NOME: %-35s │%n", imprimir.nome());
        System.out.println("├───────────────────────────────────────────┤");
        System.out.printf("│ Vida atual do inimigo: %18s │%n", imprimir.vidaAtual());
        System.out.printf("│ * Habilidades aprendidas: %16s│%n", " "); // Espaços vazios.
        for (String nomeHabAtual : imprimir.habilidadesVisiveis()) {
            System.out.printf("│ > %-39s │%n", nomeHabAtual);
        }
        System.out.println("└───────────────────────────────────────────┘");
    }

    /**
     * Imprime uma String no terminal formatada em uma caixa de diálogo.
     * @param texto Mensagem a ser impressa.
     */
    public void imprimirCaixaDialogo(String texto) {
        System.out.println();
        int tamTexto = 120;
        int nmrChar = texto.length(); // Quantidade de caracteres presentes na String.
        int espacosRestantes = Math.max(0, (tamTexto - nmrChar)); // Previne caso a String possua mais caracteres que o máximo.
        System.out.printf("┌%s┐%n", "─".repeat(122)); // Imprime 120 vezes o caractere '─'.
        System.out.print("│ ");
        ConsoleUtils.digitarLento(texto);
        System.out.printf("%" + espacosRestantes + "s │%n", " ");
        System.out.printf("└%120s┘%n", "─".repeat(122));
        System.out.println();
    }
}