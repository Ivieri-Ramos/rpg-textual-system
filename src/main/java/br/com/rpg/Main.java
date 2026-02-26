package br.com.rpg;

import br.com.rpg.controller.BatalhaController;
import br.com.rpg.controller.InventarioController;
import br.com.rpg.model.dto.InventarioAtual;
import br.com.rpg.model.entities.Heroi;
import br.com.rpg.model.entities.Inimigo;
import br.com.rpg.model.enums.ClasseHeroi;
import br.com.rpg.model.enums.ClasseInimigo;
import br.com.rpg.model.item.Equipamentos;
import br.com.rpg.model.item.Inventario;
import br.com.rpg.model.item.Item;
import br.com.rpg.view.InventarioView;
import br.com.rpg.view.Teclado;
import br.com.rpg.model.item.CatalogoEquipamentos;
import br.com.rpg.model.item.Equipamentos;
import br.com.rpg.model.item.CatalogoConsumiveis;
import br.com.rpg.model.item.Consumivel;

import java.util.List;

import static br.com.rpg.model.item.CatalogoEquipamentos.*;

public class Main {

    public static void main(String[] args) {
        // Esse bloco de inicializações é apenas para testes, será futuramente retirado isso.
        CatalogoConsumiveis.iniciarCatalogo();
        CatalogoEquipamentos.iniciarCatalogoEqp();
        Heroi jogador = new Heroi("Teste", ClasseHeroi.GUERREIRO);

        jogador.getInventario().adicionarItem(CatalogoConsumiveis.enviarConsumivel("POCAO_CURA_MENOR"));
        jogador.getInventario().adicionarItem(CatalogoConsumiveis.enviarConsumivel("POCAO_CURA_MEDIA"));
        jogador.getInventario().adicionarItem(CatalogoConsumiveis.enviarConsumivel("POCAO_MANA"));

        InventarioController controller = new InventarioController();
        Teclado input = new Teclado();

        while (true) {
            System.out.println("[1] Abrir Inventário");
            System.out.println("[0] Sair");

            int opcao = input.lerInteiro(">", 0, 1);
            if (opcao == 0) break;

            InventarioController.ResultadoInventario resultado = controller.processarInventario(jogador);

            System.out.println("\nResultado: " + resultado);
            System.out.println("HP: " + jogador.getVida() + "/" + jogador.getVidaMaxima());
            System.out.println("Mana: " + jogador.getMana());
            System.out.println("Itens restantes: " + jogador.getInventario().getItems().size());
        }
        input.fecharTeclado();
    }
}