package br.dev.juniorlatalisa.quarkus.banking.service.http;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.dev.juniorlatalisa.quarkus.banking.domain.Agencia;
import br.dev.juniorlatalisa.quarkus.banking.domain.exceptions.AgenciaNaoAtivaOuNaoEncontradaException;
import br.dev.juniorlatalisa.quarkus.banking.domain.http.SituacaoCadastral;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AgenciaService {

    @RestClient
    SituacaoCadastralHttpService situacaoCadastralHttpService;

    private final List<Agencia> agencias = new ArrayList<>();

    public void cadastrar(Agencia agencia) {
        final var response = situacaoCadastralHttpService.buscarPorCnpj(agencia.cnpj());

        if (SituacaoCadastral.ATIVO.equals(response.situacaoCadastral())) {
            agencias.add(agencia);
        } else {
             throw new AgenciaNaoAtivaOuNaoEncontradaException();
        }
    
    }

}