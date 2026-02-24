package br.com.rpg.model.enums;

/**
 * Enum para definir as constantes de Inimigo no jogo.
 * <p>
 * Inicia os atributos-base (vida, dano, chanceCrit, etc.),
 */

public enum ClasseInimigo {
/**
 * Minion Guerreiro: Inimigo básico, usado para ensinar o jogador e conseguir XP. Vida baixa, dano baixo, sem mana.
 */
    MINION_GUERREIRO(10, 5, 0, 5.0, 0.0, 10.0),
/**
 * Minion Mago: Inimigo básico, usado para ensinar o jogador e conseguir XP. 
 */
    MINION_MAGO(8, 4, 20, 3.0, 5.0, 15.0),
/**
 * Goblin: Inimigo fraco, mas ágil. Vida baixa, dano baixo, mas alta chance de esquiva.
 */
    GOBLIN(30, 8, 0, 5.0, 10.0, 25.0),
/**
 * ORC: inimigo mais resistente, mas menos ágil. Vida moderada, dano moderado, mas baixa chance de esquiva.
 */
    ORC(80, 15, 0, 20.0, 5.0, 5.0),
/**
 * dragão: Inimigo altamente resistente. Vida alta, dano alto, mas baixa chance de esquiva. Pode usar habilidades mágicas, por isso tem mana.
 */
    DRAGAO(150, 25, 50, 30.0, 5.0, 5.0),
/**
 * Troll: Definitivamente está trollando o jogador.
 */
    TROLL(15, 10, 0, 80.0, 50.0, 0.0),
/**
 * Assasino: inimigo ágil e mortal, mas frágil. Vida baixa, dano alto, alto critico.
 */
    ASSASSINO(25, 40, 0, 10.0, 90.0, 5.0);

    
    

    private final int vidaBase;
    private final int danoBase;
    private final int manaBase;
    private final double defesaBase;
    private final double chanceCritBase;
    private final double chanceEsqBase;

    /**
     * Construtor das constantes do Enum.
     * Ela define os atributos que serão usadas por cada tipo de Inimigo ao iniciar um novo jogo.
     * <p>
     * @param vidaBase
     * @param danoBase
     * @param manaBase
     * @param defesaBase
     * @param chanceCritBase
     * @param chanceEsqBase
     */

    ClasseInimigo(int vidaBase, int danoBase, int manaBase, double defesaBase, double chanceCritBase, double chanceEsqBase) {

        this.vidaBase = vidaBase;
        this.danoBase = danoBase;
        this.manaBase = manaBase;
        this.defesaBase = defesaBase;
        this.chanceCritBase = chanceCritBase;
        this.chanceEsqBase = chanceEsqBase;
    }

    public int getVidaBase() {
        return vidaBase;
    }
    public int getDanoBase() {
        return danoBase;
    }
    public int getManaBase() {
        return manaBase;
    }
    public double getDefesaBase() {
        return defesaBase;
    }
    public double getChanceCritBase() {
        return chanceCritBase;
    }
    public double getChanceEsqBase() {
        return chanceEsqBase;
    }

}