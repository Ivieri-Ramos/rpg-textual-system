package br.com.rpg.model.item;

import br.com.rpg.model.entities.Heroi;
import br.com.rpg.model.dto.ResultadoUsoItem;
import br.com.rpg.exceptions.ConsumivelNaoEncontradoException;
import br.com.rpg.model.enums.TipoConsumivel;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Classe responsável por armazenar os consumíveis contidas no jogo.
 * <p>
 * O {@link Heroi} pode utilizar consumíveis, que podem cura-lo,
 * restaurar sua mana, aumentar sua força, etc.
 */
public final class CatalogoConsumiveis{
    private static final Map<String, Consumivel> consumiveis = new HashMap<>();

    static{
        iniciarCatalogo();
    }

    /**
     * Método que instancia com todas os consumíveis criados.
     * <p>
     * <b>Importante:</b> É necessário chamar esse método para que
     * os consumíveis criados possam ser usadas.
     */
    public static void iniciarCatalogo(){

        consumiveis.put("POCAO_CURA_MENOR", new Consumivel(
                "Poção de Cura Baixa",
                "Pequena poção que restaura 50 HP",
                10, TipoConsumivel.CURA,
                heroi -> {
                    int antes = heroi.getVida();
                    heroi.receberDano(-50);
                    int curado = heroi.getVida() - antes;
                    return ResultadoUsoItem.sucesso("Você recuperou " + curado + " HP!", curado, 0);
                }
        ));

        consumiveis.put("POCAO_CURA_MEDIA", new Consumivel(
                "Poção de Cura Média",
                "Poção eficaz que restaura 150 HP",
                30, TipoConsumivel.CURA,
                heroi -> {
                    int antes = heroi.getVida();
                    heroi.receberDano(-150);
                    int curado = heroi.getVida() - antes;
                    return ResultadoUsoItem.sucesso("Você recuperou " + curado + " HP!", curado, 0);
                }
        ));

        consumiveis.put("POCAO_MANA", new Consumivel(
                "Poção mana",
                "Poção que restaura a mana",
                15, TipoConsumivel.MANA,
                heroi -> ResultadoUsoItem.sucesso("Poção de mana usada!", 0, 0)
        ));

        consumiveis.put("ANTIDOTO", new Consumivel(
                "Antidoto",
                "Cura efeitos negativos, como veneno por exemplo",
                20, TipoConsumivel.ANTIDOTO,
                heroi -> ResultadoUsoItem.sucesso("Antídoto usado!", 0, 0)
        ));

        consumiveis.put("ELIXIR_DE_FORCA", new Consumivel(
                "Elixir de força",
                "Aumenta a força",
                50, TipoConsumivel.BUFF,
                heroi -> ResultadoUsoItem.sucessoComBuff("Elixir de força usado!")
        ));
    }

    /**
     * Método que retorna uma consumível para que um {@link Heroi} a armazene.
     * @param chave Identificação do consumível.
     * @return Retorna o consumível ou {@link br.com.rpg.exceptions.ConsumivelNaoEncontradoException}
     * caso a {@code chave} seja inválida.
     */
    public static Consumivel enviarConsumivel(String chave){
        Consumivel consumivel = consumiveis.get(chave);
        if(consumivel == null){
            throw new ConsumivelNaoEncontradoException(chave);
        }
        return consumivel;
    }
}
