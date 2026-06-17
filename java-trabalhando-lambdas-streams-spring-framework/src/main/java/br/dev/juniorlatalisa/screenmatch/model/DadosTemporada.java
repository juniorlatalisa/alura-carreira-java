package br.dev.juniorlatalisa.screenmatch.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosTemporada( //
        @JsonAlias("Season") //
        Integer numero, //
        @JsonAlias("Episodes") //
        List<DadosEpisodio> episodios //
) {
    // JsonAlias serve somente para leitura e permite mais de um valor
    // JsonProperty leitura e escrita
}
