package br.com.rpg.model.entities;

import br.com.rpg.model.enums.ClasseHeroi;
import br.com.rpg.model.sistemaxp.SistemaXP;

    /**
     * Classe que será usada pelo jogador para controlar o fluxo do jogo.
     * <p>
     */

public class Heroi extends Personagem {

    private SistemaXP sistemaDeNivel = new SistemaXP();
 
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
        
    }

    /**
     * Adiciona XP ao herói e retorna a quantidade de níveis ganhos.
     *
     * @param xpGanho A quantidade de XP a ganhar
     * @return A quantidade de níveis que o herói subiu
     */
    public int ganharXP(int xpGanho) {
        return sistemaDeNivel.adicionarXp(xpGanho);
    }

    /**
     * Informa a quantidade de níveis que o herói upou.
     *
     * @param nivelUps A quantidade de níveis ganhos
     * @return A quantidade de níveis que o herói subiu
     */
    public int informarNivelUp(int nivelUps) {
        return nivelUps;
    }
    
    public SistemaXP getSistemaDeNivel() {
        return sistemaDeNivel;
    }

    @Override
    public String toString() {
        return "Heroi{" +
                super.toString();
    }



}