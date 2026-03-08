package br.com.rpg.model.habilidade;

import br.com.rpg.model.entities.Personagem;
import br.com.rpg.model.services.BatalhaService;

/**
 *
 */
@FunctionalInterface
public interface IAcaoHabilidade {
    ResultadoHabilidade executar(Habilidade habUsada, Personagem atacante, Personagem alvo, BatalhaService calculadora);
}
