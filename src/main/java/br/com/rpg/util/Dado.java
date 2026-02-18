package br.com.rpg.util;

import java.util.Random;

    /**
     * Usada para testes de rolagem e probabilidade.
     * <p>
     * Usada em cálculos de dano em ...,
     * e para testes de sucesso em {@code chanceEsq} e {@code chanceCrit}.
     */
public final class Dado {
    private static final Random dado = new Random();

    private Dado() {}

    /**
     * Método para testes de probabilidade.
     * <p>
     * @param min Menor chance possível.
     * @param max Maior chance possível.
     * @return Retorna o resultado entre o min e max escolhidos.
     */
    public static int rolar(int min, int max) {
        return dado.nextInt((max - min) + 1) + min;
    }

    /**
     * Método que testa um resultado entre 0 e 100.
     * @return Retorna o resultado entre a menor chance 0 e a maior 100.
     */
    public static int rolarD100() {
        return rolar(0, 100);
    }

    /**
     * Método que chama o {@link Dado#rolarD100()} e retorna um booleano.
     * @param chance Quantidade máxima para que o método retorne {@code true}.
     * @return Retorna {@code true} se o {@code resultado} de {@link Dado#rolarD100()}
     * for {@code <= chance}.
     */
    public static boolean testarSorte(double chance) {
        int resultado = rolarD100();
        return resultado <= chance;
    }
}