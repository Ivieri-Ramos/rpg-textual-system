package br.com.rpg.model.enums;

public enum TipoEquipamento {
    ARMARUDA, /*Equipamento no corpo inteiro, apenas uma por vez*/
    MAOPRINCIPAL, /*Usada apenas na mão dominante do personagem, podendo ser armas diversas ou focos arcanos*/
    MAOSEGUNDARIA, /*Item menor usado na mão segundaria, que serve de auxílio, como uma pequena adaga que aumenta no dano ou um escudo que aumenta a defesa*/
    ANEL, /*Item usado nos dedos, possível equipar dois. Aumenta atributos*/
    CAPA, /*Equipado nas costa, aumenta esquiva ou defesa*/
    AMULETO, /*Equipado no pescoço, (possível uso: muda o tipoElemento de um ataque normal ou aumenta o dano de uma habilidade elemental)*/
}
