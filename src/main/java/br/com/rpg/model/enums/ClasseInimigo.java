package br.com.rpg.model.enums;

import java.util.List;

/**
 * Enum para definir as constantes de Inimigo no jogo.
 * <p>
 * Inicia os atributos-base (vida, dano, chanceCrit, etc.),
 */

public enum ClasseInimigo {
    GOBLIN(30, 8, 0, 5.0, 10.0, 25.0,
            List.of("ATAQUE_NORMAL")),

    ORC(80, 15, 0, 20.0, 5.0, 5.0,
            List.of("ATAQUE_NORMAL", "ATAQUE_FORTE"));

    private final int vidaBase;
    private final int danoBase;
    private final int manaBase;
    private final double defesaBase;
    private final double chanceCritBase;
    private final double chanceEsqBase;
    private final List<String> chaveHabilidades;

    /**
     * Construtor das constantes do Enum.
     * Ela define os atributos que serão usadas por cada tipo de Inimigo ao iniciar um novo jogo.
     * @param vidaBase Vida padrão da entidade.
     * @param danoBase Dano padrão da entidade, usado para cálculos de dano.
     * @param manaBase Quantidade de mana padrão necessária para usar habilidades.
     * @param defesaBase Defesa padrão da entidade, reduz o dano recebido.
     * @param chanceCritBase Chance padrão para acontecer um crítico, aumentando o dano causado.
     * @param chanceEsqBase Chance padrão para ocorrer uma esquiva, anulando o dano recebido.
     * @param chaveHabilidades Contém as chaves para acessar as habilidades presentes em
 *              {@link br.com.rpg.model.habilidade.CatalogoHabilidades CatalogoHabilidades}.
     */

    ClasseInimigo(int vidaBase, int danoBase, int manaBase, double defesaBase,
                  double chanceCritBase, double chanceEsqBase, List<String> chaveHabilidades) {
        this.vidaBase = vidaBase;
        this.danoBase = danoBase;
        this.manaBase = manaBase;
        this.defesaBase = defesaBase;
        this.chanceCritBase = chanceCritBase;
        this.chanceEsqBase = chanceEsqBase;
        this.chaveHabilidades = chaveHabilidades;
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
    public List<String> getChaveHabilidades() {
        return chaveHabilidades;
    }

}