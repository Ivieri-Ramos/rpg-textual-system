package br.com.rpg.model.entities;

import br.com.rpg.model.enums.ClasseInimigo;

/**
 * Classe que será usada para criar inimigos no jogo.
 * <p>
 */
public class Inimigo extends Personagem {

    /**
     * Construtor especializado de Inimigo que define
     * atributos-base a partir de tipos de classes pré-definidas.
     * <p>
     * Utiliza o {@link ClasseInimigo} a partir das suas constantes Enum
     * e define os atributos-base (vida, dano, chanceCrit, etc.) usados pelo construtor
     * em {@link Personagem}, para criar a entidade Inimigo.
     * @param tipoClasse Tipos de classes pré-definidas ({@code GOBLIN}, {@code ORC}, etc.) que atribui valores base.
     * @param nome Nome identificador do inimigo.
     */
    public Inimigo(ClasseInimigo tipoClasse, String nome) {
        super(tipoClasse.getVidaBase(), tipoClasse.getDanoBase(), tipoClasse.getManaBase(),
                tipoClasse.getDefesaBase(), tipoClasse.getChanceCritBase(),
                tipoClasse.getChanceEsqBase(), nome);
    }

    @Override
    public String toString() {
        return "Inimigo{" + super.toString() + '}';
    }
}