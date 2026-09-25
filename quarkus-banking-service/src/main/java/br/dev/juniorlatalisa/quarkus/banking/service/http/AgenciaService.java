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
    private SituacaoCadastralHttpService situacaoCadastralHttpService;

    private final List<Agencia> agencias = new ArrayList<>();

    public boolean cadastrar(Agencia agencia) {
        final var response = situacaoCadastralHttpService.buscarPorCnpj(agencia.getCnpj());
        if (response == null || !SituacaoCadastral.ATIVO.equals(response.situacaoCadastral())) {
            throw new AgenciaNaoAtivaOuNaoEncontradaException();
        }
        return agencias.add(agencia);
    }

    public List<Agencia> listarTodas() {
        return agencias.stream().sorted((a1, a2) -> a1.getId().compareTo(a2.getId())).toList();
    }

    public Agencia buscarPorId(int id) {
        return agencias.stream().filter(agencia -> agencia.getId().equals(id)).toList().getFirst();
    }

    public boolean deletar(int id) {
        return agencias.removeIf(agencia -> agencia.getId().equals(id));
    }

    public boolean alterar(Agencia agencia) {
        deletar(agencia.getId());
        return cadastrar(agencia);
    }

}