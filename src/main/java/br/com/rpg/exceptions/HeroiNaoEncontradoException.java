package br.com.rpg.exceptions;

/**
 * Exception personalizado caso o {@link br.com.rpg.model.entities.heroi.CatalogoHeroi#enviarHeroi(String, String) enviarHeroi}
 * retorne {@code null}, quando a chave é passada errada.
 */
public class HeroiNaoEncontradoException extends RuntimeException {
    public HeroiNaoEncontradoException(String chaveHeroi) {
        super("Herói com chave: " + chaveHeroi + " não foi encontrado no Catálogo existente!\nVerifique novamente.");
    }
}
