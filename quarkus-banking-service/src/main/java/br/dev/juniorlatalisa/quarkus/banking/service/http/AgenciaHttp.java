package br.dev.juniorlatalisa.quarkus.banking.service.http;

public record AgenciaHttp(
    String nome,
    String razaoSocial,
    String cnpj,
    SituacaoCadastral situacaoCadastral
) {}