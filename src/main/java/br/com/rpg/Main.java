package br.com.rpg;

import br.com.rpg.controller.InventarioController;
import br.com.rpg.model.entities.inimigo.Inimigo;
import br.com.rpg.model.entities.heroi.Heroi;
import br.com.rpg.model.entities.heroi.CatalogoHeroi;
import br.com.rpg.view.Teclado;
import br.com.rpg.model.item.CatalogoEquipamentos;
import br.com.rpg.model.item.CatalogoConsumiveis;

public class Main {

    public static void main(String[] args) {
        // Esse bloco de inicializações é apenas para testes, será futuramente retirado isso.
        CatalogoHeroi.iniciarCatalogo();
        CatalogoConsumiveis.iniciarCatalogo();
        CatalogoEquipamentos.iniciarCatalogoEqp();

        Heroi jogador = CatalogoHeroi.enviarHeroi("GUERREIRO", "Teste");

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