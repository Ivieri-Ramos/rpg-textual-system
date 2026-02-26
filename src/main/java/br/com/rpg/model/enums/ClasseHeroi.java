package br.com.rpg.model.enums;

import java.util.ArrayList;
import java.util.List;

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
    GUERREIRO(100, 15, 25, 15.0, 5.0, 8.0,
            List.of("ATAQUE_NORMAL", "ATAQUE_FORTE")),
    /**
     * Classe Mago focada no uso de magias.
     * Dano e mana alta, vida e chanceEsq moderada, mas baixa defesa.
     */
    MAGO(80, 20, 50, 8.0, 5.0, 10.0,
            List.of("ATAQUE_NORMAL", "CURA_MENOR"));

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
    ClasseHeroi(int vidaBase, int danoBase, int manaBase, double defesaBase,
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
