package br.com.rpg.exceptions;

import br.com.rpg.model.entities.inimigo.CatalogoInimigo;
import br.com.rpg.model.entities.inimigo.Inimigo;

/**
 * Exception personalizado para caso em alguma linha do código
 * tenha sido digitado a chave errada para um {@link Inimigo Inimigo},
 * quando usada em {@link CatalogoInimigo#enviarInimigo(String) enviarInimigo}.
 */
public class InimigoNaoEncontradoException extends RuntimeException {
    public InimigoNaoEncontradoException(String nomeInimigo) {
        super("Inimigo de nome: " + nomeInimigo + " não foi encontrada no Catálogo existente!\nVerifique novamente.");
    }
}
