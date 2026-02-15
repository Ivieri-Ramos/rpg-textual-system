package br.com.rpg.model.entities;

import br.com.rpg.util.Dado;

public abstract class Personagem {
    /**
     * Classe abstrata herdada por {@link Heroi} e {@link Inimigo}.
     * <p>
     * Define os atributos-base de {@link Heroi} e {@link Inimigo}.
     */
    private final String nome;
    private int vida;
    private int dano;
    private int mana;
    private double defesa;
    private double chanceCrit;
    private double chanceEsq;
    private boolean isVivo = true;

    /**
     * Construtor padrão de Personagem.
     * <p>
     * A depender do tipo de Heroi ou Inimigo,
     * a quantidade de um certo atributo pode variar.
     * @param vida Máximo de dano que a entidade pode receber.
     * @param dano Quanto de vida ele pode tirar de outra entidade.
     * @param mana Atributo que permite usar magias.
     * @param defesa Quanto de dano pode anular por porcentagem.
     * @param chanceCrit Probabilidade (0-100) para que o dano da entidade aumente.
     * @param chanceEsq Probabilidade (0-100) para que a entidade esquive e anule completamente o dano.
     * @param nome Define o nome da entidade para identificação.
     */
    public Personagem(String nome, int vida, int dano, int mana, double defesa, double chanceCrit, double chanceEsq) {
        this.nome = nome;
        this.vida = vida;
        this.dano = dano;
        this.mana = mana;
        this.defesa = defesa;
        this.chanceCrit = chanceCrit;
        this.chanceEsq = chanceEsq;
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        if (vida < 0) {
            vida = 0;
        }
        this.vida = vida;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public double getDefesa() {
        return defesa;
    }

    public void setDefesa(double defesa) {
        this.defesa = defesa;
    }

    public double getChanceCrit() {
        return chanceCrit;
    }

    public void setChanceCrit(double chanceCrit) {
        this.chanceCrit = chanceCrit;
    }

    public double getChanceEsq() {
        return chanceEsq;
    }

    public void setChanceEsq(double chanceEsq) {
        this.chanceEsq = chanceEsq;
    }

    public boolean isVivo() {
        return isVivo;
    }

    public void setVivo(boolean vivo) {
        isVivo = vivo;
    }

    @Override
    public String toString() {
        return  "vida=" + vida +
                ", dano=" + dano +
                ", mana=" + mana +
                ", defesa=" + defesa +
                ", chanceCrit=" + chanceCrit +
                ", chanceEsq=" + chanceEsq +
                ", nome='" + nome + '\'' +
                '}';
    }

    public void atacar(Personagem alvo, Habilidade habilidade) {

    }
}
