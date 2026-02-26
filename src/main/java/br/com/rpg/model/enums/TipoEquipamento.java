package br.com.rpg.model.enums;

public enum TipoEquipamento {
    /**
     * Equipamento no corpo inteiro, apenas uma por vez
     */
    ARMADURA(1),
    /**
     * Usada apenas na mão dominante do personagem, podendo ser armas diversas ou focos arcanos
     */
    MAO_PRINCIPAL(1),
    /**
     * Item menor usado na mão segundaria, que serve de auxílio, como uma pequena adaga que aumenta no dano ou um escudo que aumenta a defesa
     */
    MAO_SEGUNDARIA(1),
    /**
     * Item usado nos dedos, possível equipar dois. Aumenta atributos
     */
    ANEL(2),
    /**
     * Equipado nas costa, aumenta esquiva ou defesa
     */
    CAPA(1),
    /**
     * Equipado no pescoço, (possível uso: muda o tipoElemento de um ataque normal ou aumenta o dano de uma habilidade elemental)
     */
    AMULETO(1),
    ;

    private final int quantidadeSlots;

    TipoEquipamento(int quantidadeSlots) {
        this.quantidadeSlots = quantidadeSlots;
    }

    public int getQuantidadeSlots() {
        return quantidadeSlots;
    }
}
