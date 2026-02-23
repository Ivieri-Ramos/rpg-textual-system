package br.com.rpg.model.enums;

public enum TipoEquipamento {
    /**Equipamento no corpo inteiro, apenas uma por vez*/
    ARMARUDA,
    /**Usada apenas na mão dominante do personagem, podendo ser armas diversas ou focos arcanos*/
    MAO_PRINCIPAL,
    /**Item menor usado na mão segundaria, que serve de auxílio, como uma pequena adaga que aumenta no dano ou um escudo que aumenta a defesa*/
    MAO_SEGUNDARIA,
    /**Item usado nos dedos, possível equipar dois. Aumenta atributos*/
    ANEL,
    /**Equipado nas costa, aumenta esquiva ou defesa*/
    CAPA,
    /**Equipado no pescoço, (possível uso: muda o tipoElemento de um ataque normal ou aumenta o dano de uma habilidade elemental)*/
    AMULETO,
}
