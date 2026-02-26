package br.com.rpg.model.entities.inimigo;

import br.com.rpg.exceptions.InimigoNaoEncontradoException;
import br.com.rpg.model.habilidade.CatalogoHabilidades;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class CatalogoInimigo {
    // Function recebe uma variável para transformar em um novo Objeto (nesse caso, rank afeta Inimigo).
    private static final Map<String, Function<RankInimigo, Inimigo>> mapaInimigos = new HashMap<>();

    static {
        iniciarCatalogo();
    }

    /**
     * Método que instancia e cria todos os inimigos usados no programa.
     * <p>
     * <b>Importante:</b> É necessário chamar esse método uma vez para que
     * as habilidades criadas possam ser usadas.
     */
    public static void iniciarCatalogo() {
        mapaInimigos.put("GOBLIN_COMUM", (rank) -> {
            Inimigo novoInimigo = getInimigo("Goblin", 30, 10, 30,
                8.0, 10.0, 12.0, rank.multiplicadorAtributos(),
                ClasseInimigo.GUERREIRO_SIMPLES);
            switch (rank) {
                case COMUM -> {}
                case ELITE -> {
                    novoInimigo.setNome("Goblin Elite");
                    novoInimigo.aprenderHabilidade(CatalogoHabilidades.enviarHabilidade("ATAQUE_FORTE"));
                    return novoInimigo;
                }
                case CHEFE -> {
                    novoInimigo.setNome("Rei Goblin");
                    novoInimigo.aprenderHabilidade(CatalogoHabilidades.enviarHabilidade("ATAQUE_FORTE"));
                    return novoInimigo;
                }
            }
            return novoInimigo;
        });
        mapaInimigos.put("ORC_COMUM", (rank) -> {
            Inimigo novoInimigo = getInimigo("Orc", 80, 15, 40,
                    10.0, 7.5, 5.0, rank.multiplicadorAtributos(),
                    ClasseInimigo.GUERREIRO_FORTE);
            switch (rank) {
                case COMUM -> {} // TODO: Quando tiver mais habilidades, colocá-las aqui para mais variedade
                case ELITE -> {
                    novoInimigo.setNome("Orc Elite");
                }
                case CHEFE -> {
                    novoInimigo.setNome("Rei Orc");
                }
            }
            return novoInimigo;
        });
    }

    //TODO: Quando tiver o Status, será movido esse método para lá
    // O construtor para inimigo em Status será feito dessa maneira.
    private static Inimigo getInimigo(String nomePadrao, int vidaBase, int danoBase, int manaBase,
                                      double defesaBase, double  chanceCritBase, double chanceEsqBase,
                                      double multiplicador, ClasseInimigo classe) {
        vidaBase = (int) Math.floor(vidaBase * multiplicador);
        danoBase = (int) Math.floor(danoBase * multiplicador);
        manaBase = (int) Math.floor(manaBase * multiplicador);
        defesaBase = defesaBase * multiplicador;
        chanceCritBase = chanceCritBase * multiplicador;
        chanceEsqBase = chanceEsqBase * multiplicador;
        return new Inimigo(nomePadrao, vidaBase, danoBase, manaBase,
        defesaBase, chanceCritBase, chanceEsqBase, classe.getChaveHabilidades());
    }

    /**
     * Envia um novo Inimigo, com os buffs já aplicados, pode lançar uma Exception caso a chave seja inválida.
     * @param chave Identificação no Map.
     * @param poderInimigo Rank do inimigo, afeta a força final dele.
     * @return Inimigo com todos os atributos aplicados.
     */
    public static Inimigo enviarInimigo(String chave, RankInimigo poderInimigo) {
        Function<RankInimigo, Inimigo> novoInimigo = mapaInimigos.get(chave);
        if (novoInimigo == null) {
            throw new InimigoNaoEncontradoException(chave);
        }
        return novoInimigo.apply(poderInimigo);
    }
}
