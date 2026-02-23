package br.com.rpg.model.entities;

import br.com.rpg.model.enums.ClasseHeroi;

    /**
     * Classe que será usada pelo jogador para controlar o fluxo do jogo.
     * <p>
     */

public class Heroi extends Personagem {
    private int vidaMaxima;
    private int manaMaxima;

    /**
     * Construtor especializado de Heroi que define
     * atributos-base a partir de tipos de classes pré-definidas.
     * <p>
     * Utiliza a {@link ClasseHeroi} a partir das suas constantes Enum
     * e define os atributos-base (vida, dano, chanceCrit, etc.) usados pelo construtor
     * em {@link Personagem}, para criar a entidade Heroi.
     * @param nome Identificação do jogador única (não pode ser {@code null}).
     * @param tipoClasse Tipos de classes pré-definidas ({@code Guerreiro}, {@code Mago}, etc.) que atribui valores base.
     */
    public Heroi(String nome, ClasseHeroi tipoClasse) {
        super(nome, tipoClasse.getVidaBase(), tipoClasse.getDanoBase(),
                tipoClasse.getManaBase(), tipoClasse.getDefesaBase(),
                tipoClasse.getChanceCritBase(), tipoClasse.getChanceEsqBase());
        this.vidaMaxima = tipoClasse.getVidaBase();
        this.manaMaxima = tipoClasse.getManaBase();
    }

    @Override
    public String toString() {
        return "Heroi{" +
                super.toString();
    }

    @Override
        protected int getVidaMaxima(){
        return vidaMaxima;
    }
    @Override
        protected int getManaMaxima(){
        return manaMaxima;
    }

}