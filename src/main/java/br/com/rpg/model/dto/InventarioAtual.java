package br.com.rpg.model.dto;

import java.util.ArrayList;
import java.util.List;
import br.com.rpg.model.item.Item;

/**
 * Representa o estado do inventário para exibição ou log.
 * @param itens Lista imutável dos itens atuais.
 * @param ocupados Quantidade de slots preenchidos.
 * @param capacidadeTotal Limite máximo do inventário.
 */
public record InventarioAtual(
        List<Item> itens,
        int ocupados,
        int capacidadeTotal
) {}