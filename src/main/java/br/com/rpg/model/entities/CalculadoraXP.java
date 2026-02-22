package br.com.rpg.model.entities;

/**
 * Responsável pelos cálculos de XP necessário para cada nível.
 * <p>
 * Fórmula: 10 + (nível - 1) * 5
 * - Nível 1: 10 XP
 * - Nível 2: 15 XP
 * - Nível 3: 20 XP
 * - E assim por diante...
 */
public class CalculadoraXP {

    /**
     * Calcula o XP máximo necessário para um determinado nível.
     *
     * @param nivel O nível para o qual calcular o XP máximo
     * @return O XP máximo necessário para atingir o próximo nível
     * @throws IllegalArgumentException se o nível for menor que 1
     */
    public static int calcularXpParaNivel(int nivel) {
        if (nivel < 1) {
            throw new IllegalArgumentException("Nível deve ser maior ou igual a 1");
        }
        return 10 + (nivel - 1) * 5;
    }

    /**
     * Calcula o XP total acumulado até um determinado nível.
     *
     * @param nivel O nível até o qual calcular o XP total
     * @return O XP total necessário para chegar ao nível especificado
     */
    public static int calcularXpTotalAteNivel(int nivel) {
        int xpTotal = 0;
        for (int i = 1; i < nivel; i++) {
            xpTotal += calcularXpParaNivel(i);
        }
        return xpTotal;
    }
}
