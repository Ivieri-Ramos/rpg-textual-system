package br.com.rpg.facade;

import br.com.rpg.controller.InventarioController;
import br.com.rpg.model.dto.ResultadoUsoItem;
import br.com.rpg.model.entities.Heroi;
import br.com.rpg.model.enums.TipoEquipamento;
import br.com.rpg.model.item.Consumivel;
import br.com.rpg.model.item.SetEquipamentos;

/**
 * Realiza a lógica adicional pedida por {@link InventarioController}
 */

public class InventarioFachada {

    /**
     * Consome um item consumível que está no inventário do herói.
     * @param jogador O herói que vai consumir o item
     * @param item O item que vai ser consumido
     * @return Resultado do uso que vai ser mostrado
     */

    public ResultadoUsoItem consumirItem(Heroi jogador, Consumivel item){
        ResultadoUsoItem resultado = item.usar(jogador);
        if(resultado.sucesso()){
            jogador.getInventario().removerItem(item);
        }
        return resultado;
    }

    /**
     * Equipa o equipamento pelo indice do inventário.
     * @param jogador O heroi que vai equipar
     * @param indice Indice na lista de equipamentos
     * @return true se equipou com sucesso
     */

    public boolean equiparItem(Heroi jogador, int indice){
        SetEquipamentos setEquipamentos = jogador.getSetEquipamentos();
        return setEquipamentos.equipar(jogador.getInventario(), indice);
    }

    /**
     * Desequipa o equipamento a partir do tipo que ele for.
     * @param jogador O heroi
     * @param tipo Tipo de equipamento que vai ser desequipado
     */

    public void desequiparItem(Heroi jogador, TipoEquipamento tipo){
        SetEquipamentos setEquipamentos = jogador.getSetEquipamentos();
        setEquipamentos.desequipar(jogador.getInventario(), tipo);
    }

}
