package br.com.rpg.facade;

import br.com.rpg.model.dto.ResultadoAtaque;
import br.com.rpg.model.entities.Habilidade;
import br.com.rpg.model.entities.Personagem;
import br.com.rpg.model.services.BatalhaService;
import br.com.rpg.model.services.results.CalculoDano;

public class GameFachada {
    // TODO: Métodos que realizem a mediação entre Controller - View e mudar o estado das entidades

    private final BatalhaService calculadoraBatalha = new BatalhaService();

    public ResultadoAtaque personagemAtacar(Personagem atacante, Personagem alvo, Habilidade habUsar) {
        atacante.consumirMana(habUsar.custoMana());
        CalculoDano resultado = calculadoraBatalha.calcularDano(atacante, alvo, habUsar);
        alvo.receberDano(resultado.danoFinal());
        return new ResultadoAtaque(
                atacante.getNome(),
                alvo.getNome(),
                habUsar.nome(),
                resultado.danoFinal(),
                resultado.esquivou(),
                resultado.critico(),
                alvo.isVivo()
        );
    }
}
