package br.com.rpg.model.entities;

/**
 * Implementação de {@link AplicadorBonus} para aplicar bônus a um {@link Personagem}.
 * <p>
 * Responsável por aplicar os bônus de level up calculados pelo sistema.
 */
public class PersonagemAplicadorBonus implements AplicadorBonus {

    private final Personagem personagem;

    /**
     * Construtor do PersonagemAplicadorBonus.
     *
     * @param personagem O personagem que receberá os bônus
     */
    public PersonagemAplicadorBonus(Personagem personagem) {
        this.personagem = personagem;
    }

    /**
     * Aplica os bônus de level up ao personagem.
     * <p>
     * Calcula e aplica 10% de aumento em dano e vida.
     *
     * @param bonus O resultado do bônus (contém o novo nível)
     */
    @Override
    public void aplicarBonus(ResultadoBonus bonus) {
        int bonusDano = BonusLevelUp.calcularBonusDano(personagem.getDano());
        int bonusVida = BonusLevelUp.calcularBonusVida(personagem.getVida());

        personagem.aumentarDano(bonusDano);
        personagem.aumentarVida(bonusVida);
    }
}
