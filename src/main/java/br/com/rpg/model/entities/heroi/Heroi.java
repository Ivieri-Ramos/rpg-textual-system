package br.com.rpg.model.entities.heroi;

import br.com.rpg.model.entities.Personagem;

import java.util.List;

/**
     * Classe que será usada pelo jogador para controlar o fluxo do jogo.
     * <p>
     */

public class Heroi extends Personagem {

    /**
     * Construtor especializado de Heroi que define
     * atributos-base a partir de tipos de classes pré-definidas.
     * <p>
     * Define os atributos-base (vida, dano, chanceCrit, etc.) usados pelo construtor
     * em {@link Personagem}, para criar a entidade Heroi.
     * @param nome Identificação do jogador única (não pode ser {@code null}).
     * @param vida
     * @param dano
     * @param mana
     * @param defesa
     * @param chanceCrit
     * @param chanceEsq
     * @param chaveHabilidades
     */
    public Heroi(String nome, int vida, int dano, int mana, double defesa, double chanceCrit,
                 double chanceEsq, List<String> chaveHabilidades) {
        super(nome, vida, dano, mana, defesa, chanceCrit, chanceEsq, chaveHabilidades);
    }

    @Override
    public String toString() {
        return "Heroi{" +
                super.toString();
    }

}