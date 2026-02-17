package br.com.rpg.model.services;

import br.com.rpg.model.entities.Habilidade;
import br.com.rpg.model.entities.Personagem;
import br.com.rpg.model.services.results.CalculoDano;
import br.com.rpg.util.Dado;

/**
 * Realiza cálculos de dano.
 */
public class BatalhaService {

    /**
     * Retorna um {@link CalculoDano}.
     * <p>
     * Primeiro verifica se o alvo esquivou, caso não, é calculado o dano total
     * com relação ao dano do atacante e a habilidade usada, e depois, caso
     * consiga um crítico, o dano é aumentado.
     * @param atacante {@link Personagem} que executa a habilidade escolhida.
     * @param alvo {@link Personagem} que recebe o dano.
     * @param ataque Poder escolhido que pode aplicar efeitos ou incrementar o dano total.
     * @return Um Record que armazena o {@code danoTotal} (que pode ser 0) e se houve {@code critico} ou {@code esquiva}.
     */
    public CalculoDano calcularDano(Personagem atacante, Personagem alvo, Habilidade ataque) {
        if (Dado.testarSorte(alvo.getChanceEsq())) { // Testa a esquiva do alvo, se for bem-sucedida o alvo não recebe dano.
            return new CalculoDano(0, false, true);
        }
        boolean critico = false;
        double danoAtaque = atacante.getDano() * ataque.razaoDano();
        double danoTotal = danoAtaque - ((alvo.getDefesa() / 100.0) * danoAtaque);
        if (Dado.testarSorte(atacante.getChanceCrit())) { // Testa o crítico do atacante, se for bem-sucedida, o dano aumenta em 50%.
            danoTotal *= 1.5;
            critico = true;
        }
        return new CalculoDano((int) Math.floor(danoTotal), critico, false);
    }
}
