package br.com.rpg.view;

import br.com.rpg.model.item.Equipamentos;
import br.com.rpg.model.item.SetEquipamentos;
import java.util.Map;

public class SetView {

    private final SetEquipamentos setModel;

    public SetView(SetEquipamentos setModel) {
        this.setModel = setModel;
    }

    /**
     * Exibe os bônus.
     */
    public void exibirStatusBonus() {
        System.out.println(".__________________________________________________.");
        System.out.printf("| %-22s | %-21s |\n", "Atributos de Set", "Bônus Atuais");
        System.out.println("|________________________|_________________________|");
        System.out.printf("| [1] Vida Total         | +%-20d |\n", setModel.getBonusVidaTotal());
        System.out.printf("| [2] Mana Total         | +%-20d |\n", setModel.getBonusManaTotal());
        System.out.printf("| [3] Dano Total         | +%-20d |\n", setModel.getBonusDanoTotal());
        System.out.printf("| [4] Defesa             | %-19.1f%% |\n", setModel.getBonusDefesaTotal());
        System.out.printf("| [5] Crítico            | %-19.1f%% |\n", setModel.getBonusCritTotal());
        System.out.printf("| [6] Esquiva            | %-19.1f%% |\n", setModel.getBonusEsqTotal());
        System.out.println("|________________________|_________________________|");
    }

    /**
     * Exibe os itens equipados.
     */
    public void exibirItensEquipados() {
        Map<String, Equipamentos> slots = setModel.getSlots();

        System.out.println(".__________________________________________________.");
        System.out.printf("| %-48s |\n", "Equipamentos Vestidos");
        System.out.println("|__________________________________________________|");

        if (slots.isEmpty()) {
            System.out.printf("| %-48s |\n", "Nenhum item equipado no momento.");
        } else {
            slots.forEach((slot, item) -> {
                String linha = String.format("[%s]: %s", slot, item.getNome());
                System.out.printf("| %-48s |\n", linha);
            });
        }
        System.out.println("|__________________________________________________|");
    }

    /**
     * Mensagem para quando um item é trocado.
     * Você pode chamar este método logo após o 'equipar' no seu Controller/Main.
     */
    public void exibirMensagemTroca(Equipamentos itemNovo, Equipamentos itemAntigo) {
        System.out.println("\n>> AÇÃO DE EQUIPAMENTO <<");
        if (itemAntigo != null) {
            System.out.printf("Você removeu [%s] e equipou [%s]!\n", itemAntigo.getNome(), itemNovo.getNome());
        } else {
            System.out.printf("Você equipou [%s]!\n", itemNovo.getNome());
        }
    }
}