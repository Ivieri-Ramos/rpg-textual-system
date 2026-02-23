package br.com.rpg.model.item;

import br.com.rpg.model.entities.Heroi;
import br.com.rpg.model.dto.ResultadoUsoItem;
import br.com.rpg.model.enums.TipoConsumivel;
import java.util.function.Function;

/**
 * Item consumível com efeito definido via função.
 * Permite criar itens com comportamentos completamente customizados
 * sem precisar criar uma nova classe para cada tipo de poção.
 */

public class Consumivel extends Item{

    private final TipoConsumivel tipo;
    private final Function<Heroi,ResultadoUsoItem> efeito;

    /**
     *
     * @param nome Nome do item
     * @param preco Preço do item
     * @param tipo Tipo de consumível, para colocar eles em categorias
     * @param efeito Função que define o que o item faz. Ex: heroi -> { ... }
     */
    public Consumivel(String nome, int preco, TipoConsumivel tipo, Function<Heroi,ResultadoUsoItem> efeito){
        super(nome,"Item consumível", preco);
        this.tipo = tipo;
        this.efeito = efeito;
    }

    /**
     * Usa o item no heroi que for o alvo
     * @param heroi O heroi que vai usar o item
     * @return Resultado da ação (mensagem + sucesso)
     */
    public ResultadoUsoItem usar(Heroi heroi){
        return efeito.apply(heroi);
    }

    public TipoConsumivel getTipo() {
        return tipo;
    }

    public Function<Heroi, ResultadoUsoItem> getEfeito() {
        return efeito;
    }
}
