package br.com.rpg.model.services;

import br.com.rpg.model.entities.Habilidade;
import br.com.rpg.model.entities.Personagem;
import br.com.rpg.util.Dado;

/**
 * Realiza cálculos de dano.
 */
public class BatalhaService {

    /**
     * Método para retornar o dano que um {@link Personagem} cause a outra.
     * <p>
     * Primeiro verifica se o alvo esquivou, caso não, é calculado o dano total
     * com relação ao dano do atacante e a habilidade usada, e depois, caso
     * consiga um crítico, o dano é aumentado.
     * @param atacante {@link Personagem} que executa a habilidade escolhida.
     * @param alvo {@link Personagem} que recebe o dano.
     * @param ataque Poder escolhido que pode aplicar efeitos ou incrementar o dano total.
     * @return O dano total causado (Pode ser 0 caso o alvo esquive).
     */
    public int calcularDano(Personagem atacante, Personagem alvo, Habilidade ataque) {
        if (Dado.testarSorte(alvo.getChanceEsq())) { // Testa a esquiva do alvo, se for bem-sucedida o alvo não recebe dano.
            return 0;
        }
        double danoAtaque = atacante.getDano() * ataque.razaoDano();
        double danoTotal = danoAtaque - ((alvo.getDefesa() / 100.0) * danoAtaque);
        if (Dado.testarSorte(atacante.getChanceCrit())) { // Testa o crítico do atacante, se for bem-sucedida, o dano aumenta em 50%.
            danoTotal *= 1.5;
        }
        return (int) Math.floor(danoTotal);
    }
}
