package br.dev.juniorlatalisa.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie( //
        @JsonAlias("Title") //
        String titulo, //
        @JsonAlias("totalSeasons") //
        Integer totalTemporadas, //
        @JsonAlias("imdbRating") //
        String avaliacao //
) {
    // JsonAlias serve somente para leitura e permite mais de um valor
    // JsonProperty leitura e escrita
}
