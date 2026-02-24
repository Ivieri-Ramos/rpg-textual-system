package br.com.rpg.model.dto;

import java.util.List;

/**
 * Armazena informações de {@link br.com.rpg.model.entities.Inimigo Inimigo} para
 * ser impresso em {@link br.com.rpg.view.BatalhaView#imprimirInfoInimigo imprimirInfoInimigo}
 * quando requisitado pelo usuário durante uma batalha.
 * @param nome Identificação do Inimigo.
 * @param vidaAtual Vida do Inimigo, pode ser "???" caso seja o primeiro turno da batalha.
 * @param habilidadesVisiveis Habilidades que serão reveladas, a cada novo turno é revelado uma
 *                            nova habilidade ao jogador.
 */
public record RelatorioInfoInimigo(
        String nome,
        String vidaAtual,
        List<String> habilidadesVisiveis
) {}