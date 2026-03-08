package br.com.rpg.view;

import br.com.rpg.model.habilidade.Habilidade;

import java.util.List;

/**
 * Classe que contém métodos que imprimem uma {@code List<>}.
 */
public class ListagemView {

    /**
     * Método responsável por imprimir uma {@code List<Habilidade>}.
     * @param lista Contém as habilidades a serem impressa (Pode ser vazia).
     */
    public void mostrarHabilidades(List<Habilidade> lista) {
        if (lista.isEmpty()) {
            System.out.println("Sem habilidades disponíveis!");
            return;
        }
        System.out.println("┌─────── Habilidades ────────────────────────┐");
        for (int i = 0; i < lista.size(); i++) {
            Habilidade habAtual = lista.get(i);
            System.out.printf("│ [%d] %-15s | Custo de mana: %-3d %-2s│%n",
                    (i + 1), habAtual.nome(), habAtual.custoMana(), " ");
        }
        System.out.println("└────────────────────────────────────────────┘");
    }

    /**
     * Método usado em
     * @param lista Todas as habilidades armazenadas em {@link br.com.rpg.model.entities.Personagem Personagem}
     * @param manaAtual MP que o {@link br.com.rpg.model.entities.Personagem Personagem} tem atualmente.
     */
    public void mostrarHabilidades(List<Habilidade> lista, int manaAtual) {
        if (lista.isEmpty()) {
            System.out.println("Sem habilidades disponíveis!");
            return;
        }
        System.out.printf("┌──────── Habilidades | Mana atual: %-3d ─────┐%n", manaAtual);
        for (int i = 0; i < lista.size(); i++) {
            Habilidade habAtual = lista.get(i);
            System.out.printf("│ [%d] %-15s | Custo de mana: %-3d %-2s│%n",
                    (i + 1), habAtual.nome(), habAtual.custoMana(), " ");
        }
        System.out.println("└────────────────────────────────────────────┘");
    }
}
