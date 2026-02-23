package br.com.rpg.exceptions;

/**
 * Classe Exception para caso o método {@link br.com.rpg.model.item.CatalogoConsumiveis#enviarConsumivel(String) CatalogoConsumiveis}
 * retorne {@code null}. Ou seja, se a {@code chave} não corresponder a um consumível existente.
 */
public class ConsumivelNaoEncontradoException extends RuntimeException {
    public ConsumivelNaoEncontradoException(String nomeConsumivel) {
        super("Consumível de nome: " + nomeConsumivel + " não foi encontrada no Catálogo existente!\nVerifique novamente.");
    }
}