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
     * @return Um relatório daquela ação, indicando o que ocorreu durante aquele ataque.
     */
    static ResultadoHabilidade poderOfensivo(String nomeHab, CalculoDano relatorioDano) {
        return new ResultadoHabilidade(nomeHab, 0, relatorioDano);
    }

    /**
     * Define um retorno padrão quando é uma habilidade puramente defensiva (cura)
     * @param nomeHab Identificação da habilidade.
     * @param deltaVidaRecebida Quantidade de vida ganha.
     * @return Um relatório daquela ação, indicando como ocorreu a cura.
     */
    static ResultadoHabilidade poderDefensivo(String nomeHab, int deltaVidaRecebida) {
        return new ResultadoHabilidade(nomeHab, deltaVidaRecebida, null);
    }
}