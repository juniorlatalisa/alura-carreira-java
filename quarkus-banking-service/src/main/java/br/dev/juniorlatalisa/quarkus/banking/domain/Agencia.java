package br.dev.juniorlatalisa.quarkus.banking.domain;

public record Agencia(
        Integer id,
        String nome,
        String razaoSocial,
        String cnpj,
        Endereco endereco) {
}
