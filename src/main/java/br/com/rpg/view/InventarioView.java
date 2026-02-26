package br.com.rpg.view;

import br.com.rpg.model.dto.InventarioAtual;
import br.com.rpg.model.item.Item;

import java.util.List;

/**
 * View responsável por mostrar o inventário do herói
 * Fornece métodos para listar todos os itens ou filtrar por tipo (consumíveis/equipamentos).
 */

public class InventarioView {

    /**
     * Mostra todos os itens do inventário em uma tabela.
     * @param inventario DTO contendo lista de itens e capacidade do inventário
     */

    public void mostrarInventario(InventarioAtual inventario) {
        mostrarInventarioFiltrado(inventario, "Todos", inventario.itens());
    }

    /**
     * Mostra só os consumíveis do inventário.
     * @param inventario DTO contendo lista de consumíveis filtrada
     */

    public void mostrarInventarioConsumiveis(InventarioAtual inventario) {
        mostrarInventarioFiltrado(inventario, "Consumíveis", inventario.itens());
    }

    /**
     * Mostra só os equipamentos do inventário.
     * @param inventario DTO contendo lista de equipamentos filtrada
     */

    public void mostrarInventarioEquipamentos(InventarioAtual inventario) {
        mostrarInventarioFiltrado(inventario, "Equipamentos", inventario.itens());
    }

    /**
     * Método responsável por imprimir a tabela do inventário.
     * @param inventario DTO com dados
     * @param tipo Opção filtrada, tipo Todos, Consumíveis ou Equipamentos
     * @param itens Lista genérica de itens
     */

    private void mostrarInventarioFiltrado(InventarioAtual inventario, String tipo, List<?> itens) {
        System.out.println("┌────────── Inventário ────────────────────────┐");
        System.out.printf("│ Slots: %d/%d%n", inventario.ocupados(), inventario.capacidadeTotal());

        if (itens.isEmpty()) {
            System.out.println("│ Nenhum item encontrado                  │");
        } else {
            for (int i = 0; i < itens.size(); i++) {
                Item item = (Item) itens.get(i);
                System.out.printf("│ [%d] %-25s | Preço: %-5d │%n",
                        (i + 1), item.getNome(), item.getPreco());
            }
        }
        System.out.println("└──────────────────────────────────────────────┘");
    }

    /**
     * Mostra mensagem após usar item.
     * @param mensagem Texto que vai aparecer, por exemplo: "Você recuperou 50 HP"
     */

    public void mostrarMensagemUsouItem(String mensagem) {
        System.out.println("────────────────────────────────────────────");
        System.out.println(mensagem);
        System.out.println("────────────────────────────────────────────");
    }
}