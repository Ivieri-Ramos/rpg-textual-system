package br.com.rpg.model.enums;

    /**
     * Enum para definir as constantes de Heroi no jogo.
     * <p>
     * Inicia os atributos-base (vida, dano, chanceCrit, etc.),
     * menos o nome, pois essa será definida na execução pelo jogador.
     */
public enum ClasseHeroi {

    /**
     * Classe Guerreiro focada em combate corpo a corpo.
     * Muita vida e defesa, dano moderado, mas baixa mana e chanceEsq.
     */
    GUERREIRO(100, 15, 25, 15.0, 5.0, 8.0),
    /**
     * Classe Mago focada no uso de magias.
     * Dano e mana alta, vida e chanceEsq moderada, mas baixa defesa.
     */
    MAGO(80, 20, 50, 8.0, 5.0, 10.0),
}
