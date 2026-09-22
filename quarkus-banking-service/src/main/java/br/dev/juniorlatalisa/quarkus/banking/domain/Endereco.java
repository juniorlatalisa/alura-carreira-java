package br.dev.juniorlatalisa.quarkus.banking.domain;

public record Endereco(
        Integer id,
        String rua,
        String logradouro,
        String complemento,
        Integer numero) {
}
