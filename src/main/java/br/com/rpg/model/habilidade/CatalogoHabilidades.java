package br.com.rpg.model.habilidade;

import br.com.rpg.exceptions.HabilidadeNaoEncontradaException;
import br.com.rpg.model.entities.Heroi;
import br.com.rpg.model.entities.Inimigo;
import br.com.rpg.model.entities.Personagem;
import br.com.rpg.model.enums.TipoElemento;
import br.com.rpg.model.services.results.CalculoDano;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

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
    private static final Map<String, Supplier<Habilidade>> mapaHabilidades = new HashMap<>();

    static {
        iniciarCatalogo();
    }

    /**
     * Método que instancia com todas as habilidades criadas.
     * <p>
     * <b>Importante:</b> É necessário chamar esse método uma vez para que
     * as habilidades criadas possam ser usadas.
     */
    public static void iniciarCatalogo() {
        mapaHabilidades.put("ATAQUE_NORMAL", () -> new Habilidade
                ("Ataque Normal", 0, TipoElemento.NEUTRO,
                    ((atacante, alvo, calculadora) -> {
                        CalculoDano resultado = calculadora.calcularDano(atacante, alvo, 1.0);
                        alvo.receberDano(resultado.danoFinal());
                        return ResultadoHabilidade.ataqueOfensivo("Ataque Normal", resultado);
                })));

        mapaHabilidades.put("ATAQUE_FORTE", () -> new Habilidade
                ("Ataque Forte", 10, TipoElemento.NEUTRO,
                    (atacante, alvo, calculadora) -> {
                        CalculoDano resultado = calculadora.calcularDano(atacante, alvo, 1.5);
                        alvo.receberDano(resultado.danoFinal());
                        return ResultadoHabilidade.ataqueOfensivo("Ataque Forte", resultado);
                }));
        mapaHabilidades.put("ATAQUE_VAMPIRICO", () -> new Habilidade
                ("Ataque Vampírico", 15, TipoElemento.NEUTRO,
                    ((atacante, alvo, calculadora) -> {
                        CalculoDano resultado = calculadora.calcularDano(atacante, alvo, 1.0);
                        alvo.receberDano(resultado.danoFinal());
                        int vidaCurar = (resultado.danoFinal() / 2);
                        atacante.curarVida(vidaCurar);
                        return new ResultadoHabilidade("Ataque Forte", vidaCurar, resultado);
                })));
    }

    /**
     * Método que retorna uma habilidade para que um {@link Personagem} a armazene.
     * @param chave Identificação da habilidade.
     * @return Retorna a habilidade ou {@link br.com.rpg.exceptions.HabilidadeNaoEncontradaException}
     * caso a {@code chave} seja inválida.
     */
    public static Habilidade enviarHabilidade(String chave) {
        Supplier<Habilidade> novaHabilidade = mapaHabilidades.get(chave);
        if (novaHabilidade == null) {
            throw new HabilidadeNaoEncontradaException(chave);
        }
        return novaHabilidade.get();
    }
}
