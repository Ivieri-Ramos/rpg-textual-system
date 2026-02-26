package br.com.rpg;

import br.com.rpg.controller.BatalhaController;
import br.com.rpg.model.entities.CatalogoHabilidades;
import br.com.rpg.model.entities.Heroi;
import br.com.rpg.model.entities.Inimigo;
import br.com.rpg.model.enums.ClasseHeroi;
import br.com.rpg.model.enums.ClasseInimigo;
import br.com.rpg.model.item.Equipamentos;
import br.com.rpg.model.item.Inventario;
import br.com.rpg.model.item.Item;
import br.com.rpg.view.Teclado;
import br.com.rpg.model.item.CatalogoEquipamentos;
import br.com.rpg.model.item.Equipamentos;
import br.com.rpg.model.item.SetEquipamentos;
import br.com.rpg.model.enums.TipoEquipamento;

import static br.com.rpg.model.item.CatalogoEquipamentos.*;

public class Main {

    public static void main(String[] args) {
        Teclado input = new Teclado();
        // Esse bloco de inicializações é apenas para testes, será futuramente retirado isso.
        SetEquipamentos set = new SetEquipamentos();
        Inventario inventario = new Inventario(10);

        inventario.adicionarItem(CatalogoEquipamentos.getEquipamento("ARMADURA DE COURO"));
        inventario.adicionarItem(CatalogoEquipamentos.getEquipamento("ESPADA CURTA"));
        inventario.adicionarItem(CatalogoEquipamentos.getEquipamento("MANTO DA SAÚDE"));
        inventario.adicionarItem(CatalogoEquipamentos.getEquipamento("CAPA ELUSIVA"));

        System.out.println("=== TESTE DE EQUIPAMENTO ===");

        set.equipar(inventario, 0);
        set.equipar(inventario, 0);
        set.equipar(inventario, 0);
        set.equipar(inventario, 0);

        imprimirStatus(set);

        System.out.println("\n--- DESEQUIPANDO CAPA ---");
        set.desequipar(inventario, TipoEquipamento.CAPA);

        imprimirStatus(set);
    }

    private static void imprimirStatus(SetEquipamentos set) {
        System.out.println("\nStatus Atual:");
        System.out.println("Vida: " + set.getBonusVidaTotal());
        System.out.println("Esquiva: " + set.getBonusEsqTotal());
        set.getSlots().forEach((slot, eqp) ->
                System.out.println(slot + " -> " + eqp.getNome()));
    }
}