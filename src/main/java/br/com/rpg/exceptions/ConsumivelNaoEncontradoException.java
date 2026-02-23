package br.com.rpg.exceptions;

/**
 * Classe Exception para caso o método {@link CatalogoConsumiveis#enviarConsumivel(String)}
 * retorne {@code null}. Ou seja, se a {@code chave} não corresponder a um consumível existente.
 */
public class ConsumivelNaoEncontradaException extends RuntimeException {
    public ConsumivelNaoEncontradaException(String nomeConsumivel) {
        super("Consumível de nome: " + nomeConsumivel + " não foi encontrada no Catálogo existente!\nVerifique novamente.");
    }
}