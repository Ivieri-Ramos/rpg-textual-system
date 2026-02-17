package br.com.rpg.model.dto;

import br.com.rpg.model.entities.Habilidade;
import br.com.rpg.model.entities.Personagem;

/**
 * Armazena o resultado de um ataque realizado em {@link br.com.rpg.facade.GameFachada#personagemAtacar(Personagem, Personagem, Habilidade) personagemAtacar}.
 * @param danoCausado Dano que o atacante causou no alvo.
 * @param nomeAtacante Identificação do atacante.
 * @param nomeAlvo Identificação do alvo.
 * @param habUsada Habilidade que o atacante usou contra o alvo.
 * @param esquivou {@code true} caso o alvo tenha esquivado, do contrário, {@code false}.
 * @param critico {@code true} caso o atacante tenha dado crítico, do contrário, {@code false}.
 * @param alvoMorreu {@code true} caso o alvo morreu devido ao ataque, do contrário, {@code false}.
 */
public record ResultadoAtaque (
    int danoCausado,
    String nomeAtacante,
    String nomeAlvo,
    Habilidade habUsada,
    boolean esquivou,
    boolean critico,
    boolean alvoMorreu
) {}
