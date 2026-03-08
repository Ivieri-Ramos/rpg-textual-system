package br.com.rpg.model.entities.inimigo;

import java.util.List;

/**
 * Enum para definir as constantes de Inimigo no jogo.
 * <p>
 * Inicia os atributos-base (vida, dano, chanceCrit, etc.),
 */

public enum ClasseInimigo {

    GUERREIRO_SIMPLES(List.of("ATAQUE_NORMAL")),
    GUERREIRO_FORTE(List.of("ATAQUE_NORMAL", "ATAQUE_FORTE"));

    private final List<String> chaveHabilidades;

    ClasseInimigo(List<String> chaveHabilidades) {
        this.chaveHabilidades = chaveHabilidades;
    }

    public List<String> getChaveHabilidades() {
        return chaveHabilidades;
    }
}