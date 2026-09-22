package br.dev.juniorlatalisa.quarkus.banking.domain.http;

public record AgenciaHttp(
    String nome,
    String razaoSocial,
    String cnpj,
    SituacaoCadastral situacaoCadastral
) {}