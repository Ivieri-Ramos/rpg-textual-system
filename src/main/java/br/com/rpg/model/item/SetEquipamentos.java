package br.com.rpg.model.item;

import br.com.rpg.model.enums.TipoEquipamento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SetEquipamentos {

    // Bônus Atuais Acumulados
    private int bonusVidaTotal;
    private int bonusManaTotal;
    private int bonusDanoTotal;
    private double bonusDefesaTotal;
    private double bonusCritTotal;
    private double bonusEsqTotal;

    private final Map<String, Equipamentos> slots = new HashMap<>();

    public SetEquipamentos() {
        limparBonus();
    }

    public int equipar(Inventario inventario, int indice) {
        List<Equipamentos> listaFiltrada = inventario.getListEquipamentos();
        if (indice < 0 || indice >= listaFiltrada.size()) return -1;

        Equipamentos itemParaEquipar = listaFiltrada.get(indice);
        TipoEquipamento tipo = itemParaEquipar.getTipoEqp();

        // Procura um slot livre dentro da quantidade permitida pelo Enum
        String slotDisponivel = null;
        for (int i = 0; i < tipo.getQuantidadeSlots(); i++) {
            String nomeChave = tipo.name() + "_" + i;
            if (!slots.containsKey(nomeChave)) {
                slotDisponivel = nomeChave;
                break;
            }
        }

        // Se não achou slot vazio, substitui o primeiro por padrão (ou o último)
        if (slotDisponivel == null) {
            slotDisponivel = tipo.name() + "_0";
        }


        inventario.removerItem(itemParaEquipar);
        Equipamentos itemAntigo = slots.put(slotDisponivel, itemParaEquipar);

        if (itemAntigo != null) {
            inventario.adicionarItem(itemAntigo);
        }

        atualizarBonusTotais();
        return 1;
    }

    public Equipamentos desequipar(Inventario inventario, TipoEquipamento tipo) {
        String slotParaRemover = null;
        Equipamentos itemRemovido = null;

        // Convertemos as chaves em uma lista para navegar de trás para frente
        List<String> chaves = new ArrayList<>(slots.keySet());

        for (int i = chaves.size() - 1; i >= 0; i--) {
            String chave = chaves.get(i);
            // Verifica se o item naquele slot é do tipo que queremos tirar
            if (chave.startsWith(tipo.name())) {
                slotParaRemover = chave;
                break; // Achamos o último desse tipo, paramos aqui
            }
        }

        if (slotParaRemover != null) {
            itemRemovido = slots.remove(slotParaRemover);
            inventario.adicionarItem(itemRemovido);
            atualizarBonusTotais();
        }

        return itemRemovido;
    }

    private void atualizarBonusTotais() {
        limparBonus();
        for (Equipamentos eqp : slots.values()) {
            this.bonusVidaTotal += eqp.getBonusVida();
            this.bonusManaTotal += eqp.getBonusMana();
            this.bonusDanoTotal += eqp.getBonusDano();
            this.bonusDefesaTotal += eqp.getBonusDefesa();
            this.bonusCritTotal += eqp.getBonusCrit();
            this.bonusEsqTotal += eqp.getBonusEsq();
        }
    }

    private void limparBonus() {
        this.bonusVidaTotal = 0;
        this.bonusManaTotal = 0;
        this.bonusDanoTotal = 0;
        this.bonusDefesaTotal = 0.0;
        this.bonusCritTotal = 0.0;
        this.bonusEsqTotal = 0.0;
    }

    // Getters
    public int getBonusVidaTotal() { return bonusVidaTotal; }
    public int getBonusManaTotal() { return bonusManaTotal; }
    public int getBonusDanoTotal() { return bonusDanoTotal; }
    public double getBonusDefesaTotal() { return bonusDefesaTotal; }
    public double getBonusCritTotal() { return bonusCritTotal; }
    public double getBonusEsqTotal() { return bonusEsqTotal; }

    public Map<String, Equipamentos> getSlots() {
        return slots;
    }
}