package br.com.rpg.model.enums;

    /**
     * Enum para definir as constantes de Heroi no jogo.
     * <p>
     * Inicia os atributos-base (vida, dano, chanceCrit, etc.),
     * menos o nome, pois será definida manualmente pelo jogador.
     */
public enum ClasseHeroi {

    /**
     * Classe Guerreiro focada em combate corpo a corpo.
     * Muita vida e defesa, dano moderado, mas baixa mana e chanceEsq.
     */
    GUERREIRO(100, 15, 25, 15.0, 5.0, 8.0),
    /**
     * Classe Mago focada no uso de magias.
     * Dano e mana alta, vida e chanceEsq moderada, mas baixa defesa.
     */
    MAGO(80, 20, 50, 8.0, 5.0, 10.0),

    /**
     * Classe Arqueiro focada em ataques à distância.
     * Dano e chanceEsq alta, vida e mana moderada, mas baixa defesa.
     */
    ARQUEIRO(70, 25, 30, 5.0, 15.0, 30.0),

    /**
     * Classe Ladino focada em ataques furtivos e agilidade.
     * Dano e chanceCrit alta, vida e defesa moderada, mas baixa mana.
     */
    LADINO(60, 30, 20, 10.0, 15.0, 20.0);

    private final int vidaBase;
    private final int danoBase;
    private final int manaBase;
    private final double defesaBase;
    private final double chanceCritBase;
    private final double chanceEsqBase;

    /**
     * Construtor das constantes do Enum.
     * Ela define os atributos que serão usadas por cada tipo de Heroi ao iniciar um novo jogo.
     * <p>
     * @param vidaBase
     * @param danoBase
     * @param manaBase
     * @param defesaBase
     * @param chanceCritBase
     * @param chanceEsqBase
     */
    ClasseHeroi(int vidaBase, int danoBase, int manaBase, double defesaBase, double chanceCritBase, double chanceEsqBase) {
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
