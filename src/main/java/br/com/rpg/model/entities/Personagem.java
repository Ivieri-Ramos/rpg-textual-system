package br.com.rpg.model.entities;

import br.com.rpg.model.services.BatalhaService;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe abstrata herdada por {@link Heroi} e {@link Inimigo}.
 * <p>
 * Define os atributos-base de {@link Heroi} e {@link Inimigo}.
 */
public abstract class Personagem {

    private final String nome;
    private int vida;
    private int dano;
    private int mana;
    private double defesa;
    private double chanceCrit;
    private double chanceEsq;
    private boolean isVivo = true;
    private List<Habilidade> menuHabilidades =  new ArrayList<Habilidade>();
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
     * Método usado pelo {@link Personagem} atacante para causar dano no {@link Personagem} alvo.
     * <p>
     * Primeiro chama {@link BatalhaService#calcularDano(Personagem, Personagem, Habilidade)} e por fim
     * o método {@link Personagem#receberDano(int)} para atualizar a vida do alvo.
     * @param alvo {@link Personagem} que é atacado.
     * @param habilidade Poder usado para causar dano.
     */
    public void atacar(Personagem alvo, Habilidade habilidade) {
        int danoCausado = BatalhaService.calcularDano(this, alvo, habilidade);
        alvo.receberDano(danoCausado);
        // Depois será necessário retirar o BatalhaService, mas manteremos aqui por
        // conveniência de testes.
    }

    /**
     * Método que atualiza a nova vida do {@link Personagem}.
     * <p>
     * Atualiza a vida com base na relação {@code vida - dano} e caso
     * a vida se torne 0, mude o estado {@code isVivo} para {@code false}.
     * @param danoRecebido Valor que diminui da {@code vida} atual do {@link Personagem}. <b>Obs.:</b> pode ser 0.
     */
    public void receberDano(int danoRecebido) {
        int novaVida = getVida() - danoRecebido;
        setVida(novaVida);
        if (getVida() == 0) {
            setVivo(false);
        }
    }

    /**
     * Adiciona uma nova habilidade para a entidade.
     * @param novaHabilidade habilidade advinda do {@link CatalogoHabilidades}.
     */
    public void aprenderHabilidade(Habilidade novaHabilidade) {
        menuHabilidades.add(novaHabilidade);
    }
}
