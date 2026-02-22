package br.com.rpg.model.item;

public class Equipamentos extends Item {

    private final String tipoEqp; //
    // Definir qual o tipo de equipamento para não equipar dois capacetes, mas poder equipar um capacete e uma espada//
    private final int bonusVida;
    private final int bonusDano;
    private final int bonusMana;
    private final double bonusDefesa;
    private final double bonusCrit;
    private final double bonusEsq;

    public Equipamentos (String nome, String descricao, int preco, String tipoEqp, int bonusVida, int bonusDano, int bonusMana, double bonusDefesa, double bonusCrit, double bonusEsq) {
        super(nome, descricao, preco);
        this.tipoEqp = tipoEqp;
        this.bonusVida = bonusVida;
        this.bonusDano = bonusDano;
        this.bonusMana = bonusMana;
        this.bonusDefesa = bonusDefesa;
        this.bonusCrit = bonusCrit;
        this.bonusEsq = bonusEsq;
    }

    public String getTipoEqp() {
        return tipoEqp;
    }
    public int getBonusVida() {
        return bonusVida;
    }

    public int getBonusDano() {
        return bonusDano;
    }

    public int getBonusMana() {
        return bonusMana;
    }

    public double getBonusDefesa() {
        return bonusDefesa;
    }

    public double getBonusCrit() {
        return bonusCrit;
    }

    public double getBonusEsq() {
        return bonusEsq;
    }
}