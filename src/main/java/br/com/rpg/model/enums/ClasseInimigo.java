package br.com.rpg.model.enums;

public enum ClasseInimigo {
    GOBLIN(30, 8, 0, 5.0, 10.0, 25.0),

    ORC(80, 15, 0, 20.0, 5.0, 5.0);

    private final int vidaBase;
    private final int danoBase;
    private final int manaBase;
    private final double defesaBase;
    private final double chanceCritBase;
    private final double chanceEsqBase;

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