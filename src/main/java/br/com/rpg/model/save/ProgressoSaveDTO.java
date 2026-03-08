package br.com.rpg.model.save;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ProgressoSaveDTO(
        @JsonProperty("nome_heroi")
        String nomeHeroi,

        @JsonProperty("vida_maxima")
        int vidaMaxima,

        @JsonProperty("dano_maximo")
        int dano,

        @JsonProperty("mana_maxima")
        int manaMaxima,

        @JsonProperty("defesa_maxima")
        double defesa,

        @JsonProperty("chance_critica_maxima")
        double chanceCrit,

        @JsonProperty("chance_esquiva_maxima")
        double chanceEsq,

        @JsonProperty("chave_habilidades")
        List<String> chaveHabilidades
) {}
