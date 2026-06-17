package br.dev.juniorlatalisa.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpisodio( //
        @JsonAlias("Title") //
        String titulo, //
        @JsonAlias("Episode") //
        Integer numero, //
        @JsonAlias("imdbRating") //
        String avaliacao, //
        @JsonAlias("Released") //
        String dataLancamento //
) {
    // JsonAlias serve somente para leitura e permite mais de um valor
    // JsonProperty leitura e escrita
}
