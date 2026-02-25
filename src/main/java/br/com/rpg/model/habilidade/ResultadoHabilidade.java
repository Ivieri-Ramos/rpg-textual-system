package br.com.rpg.model.habilidade;

import br.com.rpg.model.services.results.CalculoDano;

public record ResultadoHabilidade(
    String nome,
    int deltaVidaRecebida,
    CalculoDano relatorioDano
) {
    /**
     * Define um retorno padrão quando é uma habilidade puramente ofensiva.
     * @param nome Identificação da habilidade.
     * @param relatorioDano Armazena o resultado de um ataque.
     * @return Um Record já preenchido.
     */
    static ResultadoHabilidade ataqueOfensivo(String nome, CalculoDano relatorioDano) {
        return new ResultadoHabilidade(nome, 0, relatorioDano);
    }
}