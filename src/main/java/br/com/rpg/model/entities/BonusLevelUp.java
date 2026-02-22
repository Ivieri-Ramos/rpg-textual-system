package br.com.rpg.model.entities;

/**
 * Define os bônus aplicados ao subir de nível.
 * <p>
 * Responsável por calcular aumentos de atributos baseados na progressão de nível.
 */
public class BonusLevelUp {

    private static final double PERCENTUAL_BONUS = 0.10; // 10%

    /**
     * Calcula o aumento de dano baseado no percentual de bônus.
     *
     * @param danoAtual O dano atual do personagem
     * @return O diferença de dano a ser adicionado
     */
    public static int calcularBonusDano(int danoAtual) {
        int danoNovo = (int) (danoAtual * (1 + PERCENTUAL_BONUS));
        return danoNovo - danoAtual;
    }

    /**
     * Calcula o aumento de vida baseado no percentual de bônus.
     *
     * @param vidaAtual A vida atual do personagem
     * @return A diferença de vida a ser adicionada
     */
    public static int calcularBonusVida(int vidaAtual) {
        int vidaNova = (int) (vidaAtual * (1 + PERCENTUAL_BONUS));
        return vidaNova - vidaAtual;
    }

    /**
     * Retorna o percentual de bônus aplicado (para fins informativos).
     *
     * @return O percentual de bônus em formato decimal (0.10 = 10%)
     */
    public static double getPercentualBonus() {
        return PERCENTUAL_BONUS;
    }
}
