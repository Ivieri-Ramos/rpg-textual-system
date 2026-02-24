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
            System.out.println(item.getNome() + " adicionado ao inventario.");
            return true;
        }
        System.out.println("Inventario cheio.");
        return false;
    }

    public void removerItem(Item item){
        items.remove(item);
    }

    public void listarItem(){
        System.out.println("Inventario (" + items.size() + "/" + capacidade + ")");
        for(int i = 0; i < items.size(); i++){
            System.out.println((i+1) + "." + items.get(i).getNome());
        }
    }

    public List<Item> getItems() {
        return items;
    }
}
