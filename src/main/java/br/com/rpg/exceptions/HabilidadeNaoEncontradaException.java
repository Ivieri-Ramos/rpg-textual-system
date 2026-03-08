package br.com.rpg.exceptions;

import br.com.rpg.model.habilidade.CatalogoHabilidades;

/**
 * Classe Exception para caso o método {@link CatalogoHabilidades#enviarHabilidade(String)}
 * retorne {@code null}. Ou seja, se a {@code chave} não corresponder a uma habilidade existente.
 */
public class HabilidadeNaoEncontradaException extends RuntimeException {
    public HabilidadeNaoEncontradaException(String nomeHabilidade) {
        super("Habilidade de nome: " + nomeHabilidade + " não foi encontrada no Catálogo existente!\nVerifique novamente.");
    }
}
