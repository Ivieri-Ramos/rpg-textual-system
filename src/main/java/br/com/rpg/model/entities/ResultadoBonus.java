package br.com.rpg.model.entities;

/**
 * DTO contendo os bônus a aplicar ao subir de nível.
 */
public class ResultadoBonus {

    private final int bonusDano;
    private final int bonusVida;
    private final int novoNivel;

    /**
     * Construtor do ResultadoBonus.
     *
     * @param bonusDano O bônus de dano a aplicar
     * @param bonusVida O bônus de vida a aplicar
     * @param novoNivel O novo nível atingido
     */
    public ResultadoBonus(int bonusDano, int bonusVida, int novoNivel) {
        this.bonusDano = bonusDano;
        this.bonusVida = bonusVida;
        this.novoNivel = novoNivel;
    }

    public int getBonusDano() {
        return bonusDano;
    }

    public int getBonusVida() {
        return bonusVida;
    }

    public int getNovoNivel() {
        return novoNivel;
    }

    @Override
    public String toString() {
        return "ResultadoBonus{" +
                "bonusDano=" + bonusDano +
                ", bonusVida=" + bonusVida +
                ", novoNivel=" + novoNivel +
                '}';
    }
}
