package br.com.rpg.model.dto;

import br.com.rpg.model.enums.DesfechoBatalha;

/**
 * DTO responsável por armazenar o resultado de uma batalha.
 * @param nomeInimigo Identificação do Inimigo enfrentado pelo jogador.
 * @param resultado Armazena se o jogador venceu, perdeu ou fugiu.
 */
public record ResultadoBatalha(
        String nomeInimigo,
        DesfechoBatalha resultado
) {
    /**
     * Sobrecarga usada quando o jogador vence a batalha.
     * @return Um DTO representando que o jogador venceu.
     */
    public static ResultadoBatalha ganhou(String nomeInimigo) {
        return new ResultadoBatalha(nomeInimigo, DesfechoBatalha.HEROI_VENCEU);
    }

    /**
     * Sobrecarga usada quando o jogador foge da batalha.
     * @return Um DTO representando que o jogador fugiu.
     */
    public static ResultadoBatalha fugiu(String nomeInimigo) {
        return new ResultadoBatalha(nomeInimigo, DesfechoBatalha.HEROI_FUGIU);
    }

    /**
     * Sobrecarga usada quando o jogador morreu na batalha.
     * @return Um DTO representando que o jogador morreu.
     */
    public static ResultadoBatalha morreu(String nomeInimigo) {
        return new ResultadoBatalha(nomeInimigo, DesfechoBatalha.HEROI_MORREU);
    }
}
