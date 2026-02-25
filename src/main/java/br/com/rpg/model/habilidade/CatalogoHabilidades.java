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
    // O Supplier gera uma nova habilidade na memória, portanto, cada Personagem terá sua própria Habilidade.
    private static final Map<String, Supplier<Habilidade>> mapaHabilidades = new HashMap<>();

    static {
        iniciarCatalogo();
    }

    /**
     * Método que instancia e cria todas as habilidades usadas no programa.
     * <p>
     * <b>Importante:</b> É necessário chamar esse método uma vez para que
     * as habilidades criadas possam ser usadas.
     */
    public static void iniciarCatalogo() {
        mapaHabilidades.put("ATAQUE_NORMAL", () -> new Habilidade(
                "Ataque Normal", 0, TipoElemento.NEUTRO,
                    (habUsada, conjurador, alvo, calculadora) -> {
                        CalculoDano resultado = calculadora.calcularDano(conjurador, alvo, 1.0);
                        alvo.receberDano(resultado.danoFinal());
                        return ResultadoHabilidade.poderOfensivo(habUsada.nome(), resultado);
                })
        );
        mapaHabilidades.put("ATAQUE_FORTE", () -> new Habilidade(
                "Ataque Forte", 10, TipoElemento.NEUTRO,
                (habUsada, conjurador, alvo, calculadora) -> {
                        CalculoDano resultado = calculadora.calcularDano(conjurador, alvo, 1.5);
                        alvo.receberDano(resultado.danoFinal());
                        return ResultadoHabilidade.poderOfensivo(habUsada.nome(), resultado);
                })
        );
        mapaHabilidades.put("ATAQUE_VAMPIRICO", () -> new Habilidade(
                "Ataque Vampírico", 15, TipoElemento.NEUTRO,
                    (habUsada, conjurador, alvo, calculadora) -> {
                        CalculoDano resultado = calculadora.calcularDano(conjurador, alvo, 1.0);
                        alvo.receberDano(resultado.danoFinal());
                        int vidaCurar = (resultado.danoFinal() / 2); // Metade do dano causado retorna como cura.
                        conjurador.curarVida(vidaCurar);
                        return new ResultadoHabilidade(habUsada.nome(), vidaCurar, resultado);
                })
        );
        mapaHabilidades.put("CURA_MENOR", () -> new Habilidade(
           "Cura menor", 10, TipoElemento.NEUTRO,
                (habUsada, conjurador, alvo, calculadora) -> {
                    int vidaCurar = conjurador.curarVida(25);
                    return ResultadoHabilidade.poderDefensivo(habUsada.nome(), vidaCurar);
                })
        );
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
