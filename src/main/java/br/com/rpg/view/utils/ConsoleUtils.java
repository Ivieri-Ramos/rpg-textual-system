package br.com.rpg.view.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Métodos auxiliares para auxílio na impressão no console.
 */
public final class ConsoleUtils {

    private ConsoleUtils() {}

    /**
     * Limpa o console, se não conseguir, imprime muitas linhas na tela.
     */
    public static void limparTela() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                // Limpa a tela no Windows (Pode não funcionar em IDEs).
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Limpa a tela em Linux/Mac.
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Se não conseguir limpar, apenas pula 50 linhas.
            for (int i = 0; i < 50; ++i) System.out.println();
        }
    }

    /**
     * Aguarda em segundos (pausas normais).
     * @param segundos Tempo em segundos para aguardar.
     */
    public static void aguardarSegundos(int segundos) {
        aguardarMs((segundos * 1000));
    }

    /**
     * Aguarda em milissegundos (pausas curtas).
     * @param milissegundos Tempo em milissegundos para aguardar.
     */
    public static void aguardarMs(int milissegundos) {
        try {
            Thread.sleep(milissegundos);
        } catch (InterruptedException e) {
            System.err.println("Erro ao aguardar: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Sobrecarga que imprime uma mensagem caractere por caractere, em um tempo pré-definido.
     * @param mensagem Texto a ser impresso.
     */
    public static void digitarLento(String mensagem) {
        for (char c : mensagem.toCharArray()) {
            System.out.print(c);
            aguardarMs(50); // Tempo de impressão para cada letra.
        }
    }

    /**
     * Sobrecarga que imprime uma mensagem caractere por caractere, em um tempo personalizado em ms.
     * @param mensagem Texto a ser impresso.
     */
    public static void digitarLento(String mensagem, int milissegundos) {
        for (char c : mensagem.toCharArray()) {
            System.out.print(c);
            System.out.flush();
            aguardarMs(milissegundos); // Tempo de impressão para cada letra.
        }
    }

    /**
     * Quebra o texto a cada {@code maxCaracteresLinha}, permitindo escrever textos grandes sem limite.
     * @param texto Mensagem original a ser impressa.
     * @param maxCaracteresLinha Máximo de caracteres por linha.
     * @return Uma lista que representa a {@code String} original dividida em partes.
     */
    private static List<String> quebrarTexto(String texto, int maxCaracteresLinha) {
        List<String> linhas = new ArrayList<>();
        String[] palavras = texto.split(" ");
        StringBuilder linhaAtual = new StringBuilder();

        for (String palavra : palavras) {
            if (linhaAtual.length() + palavra.length() + 1 > maxCaracteresLinha) {
                linhas.add(linhaAtual.toString());
                linhaAtual = new StringBuilder();
            }
            if (!linhaAtual.isEmpty()) {
                linhaAtual.append(" ");
            }
            linhaAtual.append(palavra);
        }
        if (!linhaAtual.isEmpty()) {
            linhas.add(linhaAtual.toString());
        }
        return linhas;
    }

    /**
     * Imprime uma String no terminal formatada em uma caixa de diálogo.
     * @param texto Mensagem a ser impressa.
     */
    public static void imprimirCaixaDialogo(String texto) {
        int larguraInterna = 120; // Largura total de espaço dentro da caixa
        int maxTexto = 100; // Limite de texto para forçar a quebra antes de encostar na borda
        List<String> linhas = quebrarTexto(texto, maxTexto); // Divide o texto
        System.out.println();
        System.out.printf("┌%s┐%n", "─".repeat(larguraInterna));
        for (String linha : linhas) { // Imprime cada linha.
            System.out.print("│ ");
            ConsoleUtils.digitarLento(linha);
            int espacosRestantes = larguraInterna - 2 - linha.length();
            System.out.printf(" ".repeat(Math.max(0, espacosRestantes)) + " │%n");
        }
        System.out.printf("└%s┘%n", "─".repeat(larguraInterna));
        System.out.println();
    }
}