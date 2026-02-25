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

import static br.com.rpg.model.item.CatalogoEquipamentos.*;

public class Main {

    public static void main(String[] args) {
        Teclado input = new Teclado();
        // Esse bloco de inicializações é apenas para testes, será futuramente retirado isso.
        Inventario testeInv = new Inventario(20);
        Item drop = CatalogoEquipamentos.getEquipamento("ARMADURA DE COURO");
        testeInv.adicionarItem(drop);
        testeInv.adicionarItem(drop);
        testeInv.getItems().forEach(item -> System.out.println(item.getNome()));
        testeInv.removerItem(drop);
        testeInv.getItems().forEach(item -> System.out.println(item.getNome()));
        drop = CatalogoEquipamentos.getEquipamento("CAPA ELUSIVA");
        testeInv.adicionarItem(drop);
        testeInv.getItems().forEach(item -> System.out.println(item.getNome()));
    }
}