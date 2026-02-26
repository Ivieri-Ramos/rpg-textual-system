package br.com.rpg.model.dto;

import br.com.rpg.model.habilidade.Habilidade;
import br.com.rpg.model.entities.Personagem;
import br.com.rpg.model.habilidade.ResultadoHabilidade;

/**
 * Armazena o resultado de um ataque realizado em {@link br.com.rpg.facade.GameFachada#personagemAtacar(Personagem, Personagem, Habilidade) personagemAtacar}.
 * @param nomeAtacante Identificação do atacante.
 * @param nomeAlvo Identificação do alvo.
 * @param relatorio Record que guarda as ações realizadas durante o ataque
 */
public record ResultadoTurno(
    String nomeAtacante,
    String nomeAlvo,
    ResultadoHabilidade relatorio,
    boolean alvoMorreu
) {}
