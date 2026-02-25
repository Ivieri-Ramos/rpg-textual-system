package br.com.rpg.model.habilidade;

import br.com.rpg.model.services.results.CalculoDano;

public record ResultadoHabilidade(
    String nomeHab,
    int deltaVidaRecebida,
    CalculoDano relatorioDano
) {
    /**
     * Define um retorno padrão quando é uma habilidade puramente ofensiva.
     * @param nomeHab Identificação da habilidade.
     * @param relatorioDano Armazena o resultado de um ataque.
     * @return Um Record já preenchido.
     */
    static ResultadoHabilidade poderOfensivo(String nomeHab, CalculoDano relatorioDano) {
        return new ResultadoHabilidade(nomeHab, 0, relatorioDano);
    }

    static ResultadoHabilidade poderDefensivo(String nomeHab, int deltaVidaRecebida) {
        return new ResultadoHabilidade(nomeHab, deltaVidaRecebida, null);
    }
}