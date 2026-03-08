package br.com.rpg.model.entities.heroi;

import br.com.rpg.exceptions.HabilidadeNaoEncontradaException;
import br.com.rpg.exceptions.HeroiNaoEncontradoException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class CatalogoHeroi {
    private static final Map<String, Function<String, Heroi>> mapaHerois = new HashMap<>();

    private static void registrar(String chave, int vida, int dano, int mana,
                                  double defesa, double chanceCrit, double chanceEsq,
                                  List<String> chaveHabilidades) {
        mapaHerois.put(chave, (nomeJogador) -> new Heroi(nomeJogador, vida, dano, mana, defesa,
                chanceCrit, chanceEsq, chaveHabilidades));
    }
    static {
        iniciarCatalogo();
    }

    /**
     * Método que instancia e cria todos os heróis usados no programa.
     * <p>
     * <b>Importante:</b> É necessário chamar esse método uma vez para que
     * heróis possam ser criados para serem usados.
     */
    public static void iniciarCatalogo() {
        registrar("GUERREIRO", 100, 15, 50, 10.0, 8.0, 7.5,
                List.of("ATAQUE_NORMAL", "ATAQUE_FORTE"));
        registrar("MAGO", 90, 18, 75, 7.5, 8.0, 10.0,
                List.of("ATAQUE_NORMAL", "CURA_MENOR"));
    }

    /**
     * Método que retorna um {@link Heroi} posteriormente.
     * @param chave Identificação do herói.
     * @return Retorna herói ou {@link br.com.rpg.exceptions.HabilidadeNaoEncontradaException}
     * caso a {@code chave} seja inválida.
     */
    public static Heroi enviarHeroi(String chave, String nomeJogador) {
        Function<String, Heroi> novoHeroi = mapaHerois.get(chave);
        if (novoHeroi == null) {
            throw new HeroiNaoEncontradoException(chave);
        }
        return novoHeroi.apply(nomeJogador);
    }
}
