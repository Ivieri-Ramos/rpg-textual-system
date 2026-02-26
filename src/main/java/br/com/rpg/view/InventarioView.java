package br.com.rpg.view;

import br.com.rpg.model.dto.InventarioAtual;
import br.com.rpg.model.item.Item;
import br.com.rpg.view.utils.ConsoleUtils;

import java.util.List;

/**
 * View responsável por mostrar o inventário do herói.
 * Fornece métodos para listar todos os itens ou filtrar por tipo.
 */
public class InventarioView {

    /**
     * Exibe o menu de opções de filtro do inventário.
     */
    public void mostrarMenuFiltro() {
        System.out.println("\n[1] Ver todos os itens");
        System.out.println("[2] Ver apenas consumíveis");
        System.out.println("[3] Ver apenas equipamentos");
        System.out.println("[0] Voltar");
    }

    /**
     * Método privado que imprime a tabela do inventário.
     * @param inventario DTO com dados do inventário
     * @param tipo Título do tipo de itens a ser exibido
     * @param itens Lista genérica de itens
     */
    private void mostrarInventario(InventarioAtual inventario, String tipo, List<? extends Item> itens) {
        System.out.println("┌────────── Inventário  ───────────────────────┐");
        System.out.printf("│ Slots: %d/%d%n", inventario.ocupados(), inventario.capacidadeTotal());

        if (itens.isEmpty()) {
            System.out.println("│ Nenhum item encontrado                  │");
        } else {
            for (int i = 0; i < itens.size(); i++) {
                Item item = itens.get(i);
                System.out.printf("│ [%d] %-25s | Preço: %-5d │%n",
                        (i + 1), item.getNome(), item.getPreco());
            }
        }
        System.out.println("└──────────────────────────────────────────────┘");
    }

    /**
     * Mostra todos os itens do inventário.
     * @param inventario DTO contendo todos os itens
     */
    public void mostrarInventario(InventarioAtual inventario) {
        mostrarInventario(inventario, "Todos", inventario.itens());
    }

    /**
     * Mostra apenas os consumíveis do inventário.
     * @param inventario DTO contendo lista de consumíveis filtrada
     */
    public void mostrarInventarioConsumiveis(InventarioAtual inventario) {
        mostrarInventario(inventario, "Consumíveis", inventario.itens());
    }

    /**
     * Mostra apenas os equipamentos do inventário.
     * @param inventario DTO contendo lista de equipamentos filtrada
     */
    public void mostrarInventarioEquipamentos(InventarioAtual inventario) {
        mostrarInventario(inventario, "Equipamentos", inventario.itens());
    }

    /**
     * Imprime uma String no terminal formatada em uma caixa de diálogo.
     * @param texto Mensagem a ser impressa.
     */
    public void imprimirCaixaDialogo(String texto) {
        System.out.println();
        int tamTexto = 120;
        int nmrChar = texto.length(); // Quantidade de caracteres presentes na String.
        int espacosRestantes = Math.max(0, (tamTexto - nmrChar)); // Previne caso a String possua mais caracteres que o máximo.
        System.out.printf("┌%s┐%n", "─".repeat(122)); // Imprime 120 vezes o caractere '─'.
        System.out.print("│ ");
        ConsoleUtils.digitarLento(texto);
        System.out.printf("%" + espacosRestantes + "s │%n", " ");
        System.out.printf("└%120s┘%n", "─".repeat(122));
        System.out.println();
    }

    /**
     * Mostra mensagem após usar um item.
     * @param mensagem Texto que vai aparecer, por exemplo: "Você recuperou 50 HP"
     */
    public void mostrarMensagemUsouItem(String mensagem) {
        imprimirCaixaDialogo(mensagem);
    }
}