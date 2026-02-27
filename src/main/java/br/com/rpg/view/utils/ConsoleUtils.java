package br.com.rpg.view.utils;

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
     * Imprime uma String no terminal formatada em uma caixa de diálogo.
     * @param texto Mensagem a ser impressa.
     */
    public static void imprimirCaixaDialogo(String texto) {
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