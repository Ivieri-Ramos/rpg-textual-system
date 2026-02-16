package br.com.rpg.model.entities;

import br.com.rpg.exceptions.HabilidadeNaoEncontradaException;
import br.com.rpg.model.enums.TipoElemento;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe responsável por armazenar as habilidades contidas no jogo.
 * <p>
 * É instanciada uma única vez, usada para carregar as habilidades de
 * cada {@link Personagem} no jogo durante a execução.
 * <p>
 * O {@link Heroi} pode aprender novas habilidades, enquanto o
 * {@link Inimigo} terá poderes pré-definidos.
 */
public final class CatalogoHabilidades {
    private static final Map<String, Habilidade> mapaHabilidades = new HashMap<>();

    /**
     * Método que instancia com todas as habilidades criadas.
     * <p>
     * <b>Importante:</b> É necessário chamar esse método uma vez para que
     * as habilidades criadas possam ser usadas.
     */
    public static void iniciarCatalogo() {
        mapaHabilidades.put("ATAQUE_NORMAL", new Habilidade("Ataque Normal", 0, 1.0, TipoElemento.NEUTRO));
        mapaHabilidades.put("ATAQUE_FORTE", new Habilidade("Ataque Forte", 10, 1.2, TipoElemento.NEUTRO));
    }

    /**
     * Método que retorna uma habilidade para que um {@link Personagem} a armazene.
     * @param chave Identificação da habilidade.
     * @return Retorna a habilidade ou {@link br.com.rpg.exceptions.HabilidadeNaoEncontradaException}
     * caso a {@code chave} seja inválida.
     */
    public static Habilidade enviarHabilidade(String chave) {
        Habilidade novaHabilidade = mapaHabilidades.get(chave);
        if (novaHabilidade == null) {
            throw new HabilidadeNaoEncontradaException(chave);
        }
        return novaHabilidade;
    }
}
