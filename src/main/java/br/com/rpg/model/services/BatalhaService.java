package br.com.rpg.model.services;

import br.com.rpg.model.habilidade.Habilidade;
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
     * @return Um Record que armazena o {@code danoTotal} (que pode ser 0) e se houve {@code critico}, {@code esquiva} ou {@code defesa}.
     */
    public CalculoDano calcularDano(Personagem atacante, Personagem alvo, Habilidade ataque) {
        // Testa a esquiva do alvo (não pode se esquivar caso esteja defendendo), se for bem-sucedida o alvo não recebe dano.
        if (Dado.testarSorte(alvo.getChanceEsq()) && !alvo.isDefendendo()) {
            return new CalculoDano(0, false, true, false);
        }
        boolean critico = false;
        boolean alvoDefendeu = false;
        double danoAtaque = atacante.getDano() * ataque.razaoDano();
        double danoTotal = danoAtaque - ((alvo.getDefesa() / 100.0) * danoAtaque);
        if (alvo.isDefendendo()) { // Se o alvo estiver defendendo, recebe metade do dano.
            danoTotal *= 0.5;
            alvoDefendeu = true;
        }
        if (Dado.testarSorte(atacante.getChanceCrit())) { // Testa o crítico do atacante, se for bem-sucedida, o dano aumenta em 50%.
            danoTotal *= 1.5;
            critico = true;
        }
        return new CalculoDano((int) Math.floor(danoTotal), critico, false, alvoDefendeu);
    }
}
