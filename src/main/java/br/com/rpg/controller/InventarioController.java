package br.com.rpg.controller;

import br.com.rpg.facade.InventarioFachada;
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
 * Controla as interações do jogador com o inventário em um loop interno.
 * <p>
 * Gerencia a exibição, filtragem e ações sobre itens até que o jogador escolha sair
 * ou uma ação que consuma o turno seja realizada.
 */
public class InventarioController {

    private final InventarioView view = new InventarioView();
    private final Teclado input = new Teclado();
    private final InventarioFachada fachada = new InventarioFachada();

    /**
     * Enum para informar o resultado da interação com inventário.
     * Diz se o turno do jogador foi consumido.
     */
    public enum ResultadoInventario {
        ITEM_CONSUMIDO, EQUIPADO, NENHUMA_ACAO, VAZIO
    }

    /**
     * Processa a interação completa com o inventário do herói.
     * Mantém um loop interno até que o jogador escolha voltar ou consuma um item.
     *
     * @param jogador O herói que terá acesso ao inventário
     * @return O resultado da ação no inventário
     */
    public ResultadoInventario processarInventario(Heroi jogador) {
        Inventario inventario = jogador.getInventario();

        if (inventario.getItems().isEmpty()) {
            exibirInventarioVazio(inventario);
            input.aguardarEnter();
            return ResultadoInventario.VAZIO;
        }

        while (true) {
            view.mostrarMenuFiltro();
            int filtro = input.lerInteiro("Escolha uma opção:", 0, 3);

            if (filtro == 0) {
                return ResultadoInventario.NENHUMA_ACAO;
            }

            List<? extends Item> itens = filtrarItens(inventario, filtro);
            if (itens.isEmpty()) {
                System.out.println("Nenhum item encontrado");
                continue;
            }

            exibirItens(filtro, itens);
            ResultadoInventario resultado = processarEscolha(jogador, itens);

            if (resultado == ResultadoInventario.ITEM_CONSUMIDO) {
                return resultado;
            }
        }
    }

    /**
     * Exibe o inventário quando está vazio.
     * @param inventario O inventário que vai ser exibido
     */
    private void exibirInventarioVazio(Inventario inventario) {
        List<Item> itens = inventario.getItems();
        InventarioAtual dto = new InventarioAtual(itens, itens.size(), 20);
        view.mostrarInventarioConsumiveis(dto);
    }

    /**
     * Filtra os itens do inventário com base na escolha do jogador.
     *
     * @param inventario O inventário a ser filtrado
     * @param filtro O tipo de filtro (1=todos, 2=consumíveis, 3=equipamentos)
     * @return Lista de itens filtrados
     */
    private List<? extends Item> filtrarItens(Inventario inventario, int filtro) {
        return switch (filtro) {
            case 1 -> inventario.getItems();
            case 2 -> inventario.getListConsumiveis();
            case 3 -> inventario.getListEquipamentos();
            default -> List.of();
        };
    }

    /**
     * Exibe os itens filtrados na view.
     *
     * @param filtro O tipo de filtro aplicado
     * @param itens Lista de itens que vai ser exibida
     */
    private void exibirItens(int filtro, List<? extends Item> itens) {
        InventarioAtual dto = new InventarioAtual(itens, itens.size(), 20);

        switch (filtro) {
            case 1 -> view.mostrarInventario(dto);
            case 2 -> view.mostrarInventarioConsumiveis(dto);
            case 3 -> view.mostrarInventarioEquipamentos(dto);
        }
    }

    /**
     * Processa a escolha do item pelo jogador.
     *
     * @param jogador O herói
     * @param itens Lista de itens disponíveis para escolha
     * @return O resultado da ação sobre o item
     */
    private ResultadoInventario processarEscolha(Heroi jogador, List<? extends Item> itens) {
        int escolha = input.lerInteiro("Selecione o item (0 para voltar):", 0, itens.size());

        if (escolha == 0) {
            return ResultadoInventario.NENHUMA_ACAO;
        }

        Item item = itens.get(escolha - 1);

        if (item instanceof Consumivel consumivel) {
            var resultado = fachada.consumirItem(jogador, consumivel);
            view.mostrarMensagemUsouItem(resultado.mensagem());
            return ResultadoInventario.ITEM_CONSUMIDO;
        } else if (item instanceof Equipamentos) {
            boolean equipou = fachada.equiparItem(jogador, escolha - 1);
            // TODO: Sistema de mensagens de equipamento
            return equipou ? ResultadoInventario.EQUIPADO : ResultadoInventario.NENHUMA_ACAO;
        }

        return ResultadoInventario.NENHUMA_ACAO;
    }
}