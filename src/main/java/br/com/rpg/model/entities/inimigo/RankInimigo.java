package br.com.rpg.model.entities.inimigo;

public enum RankInimigo {
    COMUM,
    ELITE,
    CHEFE;

    public double multiplicadorAtributos() {
        switch (this) {
            case COMUM -> {
                return 1.0;
            }
            case ELITE -> {
                return 1.25;
            }
            case CHEFE -> {
                return 1.75;
            }
        }
        return 1.0;
    }
}
