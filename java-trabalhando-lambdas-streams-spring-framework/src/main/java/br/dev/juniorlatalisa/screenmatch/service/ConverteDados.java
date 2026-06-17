package br.dev.juniorlatalisa.screenmatch.service;

import tools.jackson.databind.ObjectMapper;

public class ConverteDados {

    private final ObjectMapper mapper = new ObjectMapper();

    public <T> T obterDados(Class<T> type, String json) {
        return mapper.readValue(json, type);
    }

}
