package br.com.rpg.facade;

import br.com.rpg.model.entities.Habilidade;
import br.com.rpg.model.entities.Personagem;
import br.com.rpg.model.services.BatalhaService;

public class GameFachada {
    // TODO: Métodos que realizem a mediação entre Controller - View e mudar o estado das entidades

    private BatalhaService calculadoraBatalha = new BatalhaService();

    public String personagemAtacar(Personagem atacante, Personagem alvo, Habilidade habUsar) {
        atacante.consumirMana(habUsar.custoMana());
        int danoCausado = calculadoraBatalha.calcularDano(atacante, alvo, habUsar);
        alvo.receberDano(danoCausado);
        String mensagem = atacante.getNome() + " atacou " + alvo.getNome() + " com a habilidade " + habUsar.nome()
        return
    }
}
