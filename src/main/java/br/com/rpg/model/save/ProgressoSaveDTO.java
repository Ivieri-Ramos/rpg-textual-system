package br.com.rpg.model.save;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

// Mantém o arquivo .csv criado em ordem
@JsonPropertyOrder({
        "nome_heroi",
        "vida_maxima",
        "dano_maximo",
        "mana_maxima",
        "defesa_maxima",
        "chance_critica_maxima",
        "chance_esquiva_maxima",
        "chave_habilidades"
})

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
