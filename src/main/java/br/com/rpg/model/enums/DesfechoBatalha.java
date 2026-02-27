package br.com.rpg.model.enums;

/**
 * Representa o desfecho definitivo de uma luta, ou seja,
 * se o jogador morreu, venceu ou se fugiu.
 */
public enum DesfechoBatalha {
    /**
     * Representa o caso do jogador ter ganhado a batalha.
     */
    HEROI_VENCEU,
    /**
     * Representa o caso do jogador ter morrido durante a batalha.
     */
    HEROI_MORREU,
    /**
     * Representa o caso do jogador ter fugido durante a batalha.
     */
    HEROI_FUGIU,
}
