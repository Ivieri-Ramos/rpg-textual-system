package br.com.rpg.view;

import br.com.rpg.model.entities.Habilidade;

import java.util.List;

/**
 * Classe {@code final} que contém métodos {@code static} que imprimem {@code List<>}.
 */
public final class ListagemView {

    /**
     * Método {@code static} responsável por imprimir uma {@code List<Habilidade>}.
     * @param lista Contém as habilidades a serem impressa (Pode ser vazia).
     */
    public static void mostrarHabilidades(List<Habilidade> lista) {
        if (lista.isEmpty()) {
            System.out.println("Sem habilidades disponíveis!");
            return;
        }
        System.out.println("┌── Habilidades ───────────────────────┐");
        for (int i = 0; i < lista.size(); i++) {
            Habilidade habAtual = lista.get(i);
            System.out.printf("│ [%d] %-15s | MP: %-3d      │%n",
                    (i + 1), habAtual.nome(), habAtual.custoMana());
        }
        System.out.println("└──────────────────────────────────────┘");
    }
}
