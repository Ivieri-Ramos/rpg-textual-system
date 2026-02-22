package br.com.rpg.model.entities;

/**
 * Interface para aplicar efeitos de level up a uma entidade.
 * <p>
 * Permite que o sistema de XP seja independente da implementação específica
 * de como os bônus são aplicados.
 */
public interface AplicadorBonus {

    /**
     * Aplica os bônus de level up a uma entidade.
     *
     * @param bonus O objeto contendo as informações de bônus a aplicar
     */
    void aplicarBonus(ResultadoBonus bonus);
}
