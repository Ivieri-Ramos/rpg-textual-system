package br.com.rpg.model.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Herdada por {@link Heroi} e {@link Inimigo}.
 * <p>
 * Define os atributos-base de {@link Heroi} e {@link Inimigo}.
 */
public abstract class Personagem {

    private final String nome;
    private int vida;
    private int vidaMaxima;
    private int dano;
    private int mana;
    private int manaMaxima;
    private double defesa;
    private double chanceCrit;
    private double chanceEsq;
    private boolean isVivo = true;
    private boolean isDefendendo = false;
    private final List<Habilidade> menuHabilidades = new ArrayList<>();
    /**
     * Construtor padrão de Personagem.
     * <p>
     * A depender do tipo de Heroi ou Inimigo,
     * a quantidade de um certo atributo pode variar.
     * @param nome Define o nome da entidade para identificação.
     * @param vida Máximo de dano que a entidade pode receber.
     * @param dano Quanto de vida ele pode tirar de outra entidade.
     * @param mana Atributo que permite usar magias.
     * @param defesa Quanto de dano pode anular por porcentagem.
     * @param chanceCrit Probabilidade (0-100) para que o dano da entidade aumente.
     * @param chanceEsq Probabilidade (0-100) para que a entidade esquive e anule completamente o dano.
     */
    public Personagem(String nome, int vida, int dano, int mana, double defesa, double chanceCrit, double chanceEsq) {
        this.nome = nome;
        this.vida = vida;
        this.vidaMaxima = vida;
        this.dano = dano;
        this.mana = mana;
        this.manaMaxima = mana;
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

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    private void setVida(int vida) {
        if (vida < 0) {
            vida = 0;
        }
        if(vida > vidaMaxima){
            vida = getVidaMaxima();
        }
        this.vida = vida;
    }

    public int getMana() {
        return mana;
    }

    public int getManaMaxima() {
        return manaMaxima;
    }

    private void setMana(int mana) {
        if (mana < 0) {
            mana = 0;
        }
        if(mana > manaMaxima){
            mana = getManaMaxima();
        }
        this.mana = mana;
    }

    public int getDano() {
        return dano;
    }

    private void setDano(int dano) {
        this.dano = dano;
    }

    public double getDefesa() {
        return defesa;
    }

    private void setDefesa(double defesa) {
        this.defesa = defesa;
    }

    public double getChanceCrit() {
        return chanceCrit;
    }

    private void setChanceCrit(double chanceCrit) {
        this.chanceCrit = chanceCrit;
    }

    public double getChanceEsq() {
        return chanceEsq;
    }

    private void setChanceEsq(double chanceEsq) {
        this.chanceEsq = chanceEsq;
    }

    public boolean isVivo() {
        return isVivo;
    }

    private void setVivo(boolean vivo) {
        isVivo = vivo;
    }

    public boolean isDefendendo() {
        return isDefendendo;
    }

    public void setDefendendo(boolean defendendo) {
        isDefendendo = defendendo;
    }

    public List<Habilidade> getMenuHabilidades() {
        return menuHabilidades;
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

    /**
     * Consome mana da entidade na relação {@code manaAtual - manaGasta}.
     * @param manaGasta Quantidade de {@code} a ser diminuída.
     */
    public void consumirMana(int manaGasta) {
        setMana((getMana() - manaGasta));
    }

    /**
     * Método que atualiza a nova vida do {@link Personagem}.
     * <p>
     * Atualiza a vida com base na relação {@code vida - dano} e caso
     * a vida se torne 0, mude o estado {@code isVivo} para {@code false}.
     * @param danoRecebido Valor que diminui da {@code vida} atual do {@link Personagem}. <b>Obs.:</b> pode ser 0.
     */
    public void receberDano(int danoRecebido) {
        setVida((getVida() - danoRecebido));
        if (getVida() == 0) { // Se a vida chegou em 0, é porque morreu.
            setVivo(false);
        }
        setDefendendo(false); // Se tomou dano, muda o estado de isDefendendo para false.
    }

    /**
     * Adiciona uma nova habilidade para a entidade.
     * @param novaHabilidade habilidade advinda do {@link CatalogoHabilidades}.
     */
    public void aprenderHabilidade(Habilidade novaHabilidade) {
        menuHabilidades.add(novaHabilidade);
    }

    public int curarVida(int quantidade){
        int vidaAntes = getVida();
        int novaVida = Math.min(vidaAntes + quantidade, getVidaMaxima());
        setVida(novaVida);
        return novaVida - vidaAntes;
    }

    public int curarMana(int quantidade){
        int manaAntes = getMana();
        int novaMana = Math.min(manaAntes + quantidade, getManaMaxima());
        setMana(novaMana);
        return novaMana - manaAntes;
    }
}
