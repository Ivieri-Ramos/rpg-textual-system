package br.com.rpg.model.services.results;

import br.com.rpg.model.entities.Habilidade;
import br.com.rpg.model.entities.Personagem;

/**
 * Armazena o resultado acontecido dentro do método
 * {@link br.com.rpg.model.services.BatalhaService#calcularDano(Personagem, Personagem, Habilidade) calcularDano}.
 * <p>
 * É usada para preencher o {@link br.com.rpg.model.dto.ResultadoAtaque ResultadoAtaque} e
 * depois ser impressa para o usuário.
 * @param danoFinal Dano final do resultado (pode ser 0 se o alvo esquivar).
 * @param critico {@code true} se o atacante der crítico, do contrário, {@code false}.
 * @param esquivou {@code true} se o alvo esquivar, do contrário, {@code false}.
 */
public record CalculoDano(
        int danoFinal,
        boolean critico,
        boolean esquivou
) {
}
