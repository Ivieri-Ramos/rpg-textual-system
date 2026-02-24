package br.com.rpg.model.item;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private final List<Item> items;
    private int capacidade;

    public Inventario(int capacidade) {
        this.items = new ArrayList<>();
        this.capacidade = capacidade;
    }

    public boolean adicionarItem(Item item){
        if(items.size()<capacidade){
            items.add(item);
            return true;
        }
        return false;
    }

    public void removerItem(Item item){
        items.remove(item);
    }

    public List<Item> getItems() {
        return items;
    }
}
