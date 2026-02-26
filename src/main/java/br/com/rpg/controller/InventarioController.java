package br.com.rpg.controller;

import br.com.rpg.model.dto.InventarioAtual;
import br.com.rpg.model.entities.Heroi;
import br.com.rpg.model.item.Consumivel;
import br.com.rpg.model.item.Equipamentos;
import br.com.rpg.model.item.Inventario;
import br.com.rpg.model.item.Item;
import br.com.rpg.view.InventarioView;
import br.com.rpg.view.Teclado;

import java.util.List;

/**
 * Classe responśavel por gerenciar todas as interações do jogador com o inventário.
 * O método {@link #processarInventario(Heroi)} é o ponto de partida
 */

public class InventarioController {

    private final InventarioView inventarioView = new InventarioView();
    private final Teclado input = new Teclado();

    /**
     *Enum para informar o resultado da interação com inventário.
     */

    public enum ResultadoInventario {
        ITEM_CONSUMIDO,
        EQUIPADO,
        NENHUMA_ACAO,
        VAZIO
    }

    /**
     * Método que processa a interação completa do jogador com o inventário.
     * <p>
     * Mostra menu de filtro, exibe itens e processa escolha do jogador.
     * @param jogador Instância do herói cujo inventário será manipulado.
     * @return Resultado da ação para o BatalhaController decidir sobre o turno
     */

    public ResultadoInventario processarInventario(Heroi jogador) {
        Inventario inventario = jogador.getInventario();

        if (inventario.getItems().isEmpty()) {
            InventarioAtual dto = criarDTO(inventario);
            inventarioView.mostrarInventario(dto);
            input.aguardarEnter();
            return ResultadoInventario.VAZIO;
        }

        System.out.println("\n[1] Ver todos os itens");
        System.out.println("[2] Ver apenas consumíveis");
        System.out.println("[3] Ver apenas equipamentos");
        System.out.println("[0] Voltar");

        int filtro = input.lerInteiro("Escolha uma opção:", 0, 3);

        List<? extends Item> itensFiltrados = switch (filtro) {
            case 1 -> inventario.getItems();
            case 2 -> inventario.getListConsumiveis();
            case 3 -> inventario.getListEquipamentos();
            default -> List.of();
        };

        if (itensFiltrados.isEmpty()) {
            return ResultadoInventario.NENHUMA_ACAO;
        }

        InventarioAtual dto = new InventarioAtual(
                List.copyOf(itensFiltrados),
                itensFiltrados.size(),
                20
        );

        switch (filtro) {
            case 1 -> inventarioView.mostrarInventario(dto);
            case 2 -> inventarioView.mostrarInventarioConsumiveis(dto);
            case 3 -> inventarioView.mostrarInventarioEquipamentos(dto);
            default -> {}
        }

        int escolha = input.lerInteiro("Selecione o item (0 para cancelar):", 0, itensFiltrados.size());

        if (escolha == 0) {
            return ResultadoInventario.NENHUMA_ACAO;
        }

        Item itemSelecionado = itensFiltrados.get(escolha - 1);

        if (itemSelecionado instanceof Consumivel consumivel) {
            var resultado = consumivel.usar(jogador);
            inventario.removerItem(itemSelecionado);
            inventarioView.mostrarMensagemUsouItem(resultado.mensagem());
            return ResultadoInventario.ITEM_CONSUMIDO;

        } else if (itemSelecionado instanceof Equipamentos equipamento) {
            inventarioView.mostrarMensagemUsouItem("");
            //TODO: Implementar equipar aqui
            return ResultadoInventario.NENHUMA_ACAO;
        }

        return ResultadoInventario.NENHUMA_ACAO;
    }

    /**
     * Método que cria uma instância de InventarioAtual a partir do inventário real do herói.
     * @param inventario O inventário fonte dos dados
     * @return DTO que vai ser transmitido para a View
     */

    private InventarioAtual criarDTO(Inventario inventario) {
        return new InventarioAtual(
                List.copyOf(inventario.getItems()),
                inventario.getItems().size(),
                20
        );
    }

}