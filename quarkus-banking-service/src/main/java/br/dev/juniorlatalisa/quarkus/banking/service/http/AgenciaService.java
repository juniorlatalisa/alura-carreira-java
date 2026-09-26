package br.dev.juniorlatalisa.quarkus.banking.service.http;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.dev.juniorlatalisa.quarkus.banking.domain.Agencia;
import br.dev.juniorlatalisa.quarkus.banking.domain.exceptions.AgenciaNaoAtivaOuNaoEncontradaException;
import br.dev.juniorlatalisa.quarkus.banking.domain.http.SituacaoCadastral;
import br.dev.juniorlatalisa.quarkus.banking.repository.AgenciaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.PersistenceException;
import jakarta.resource.spi.IllegalStateException;

@ApplicationScoped
public class AgenciaService {

    @RestClient
    private SituacaoCadastralHttpService situacaoCadastralHttpService;
    @Inject
    private final AgenciaRepository agenciaRepository;

    public AgenciaService(AgenciaRepository agenciaRepository) {
        this.agenciaRepository = agenciaRepository;
    }

    public boolean cadastrar(Agencia agencia) {
        if (agencia.getId() != null) {
            throw new IllegalArgumentException("O ID não deve ser informado no cadastro.");
        }
        final var response = situacaoCadastralHttpService.buscarPorCnpj(agencia.getCnpj());
        if (response == null || !SituacaoCadastral.ATIVO.equals(response.situacaoCadastral())) {
            throw new AgenciaNaoAtivaOuNaoEncontradaException();
        }
        agenciaRepository.persist(agencia);
        return true;
    }

    public List<Agencia> listarTodas() {
        return agenciaRepository.listAll();
        // return agencias.stream().sorted((a1, a2) ->
        // a1.getId().compareTo(a2.getId())).toList();
    }

    public Agencia buscarPorId(long id) {
        return agenciaRepository.findById(id);
        // return agencias.stream().filter(agencia ->
        // agencia.getId().equals(id)).toList().getFirst();
    }

    public boolean deletar(long id) {
        return agenciaRepository.deleteById(id);
        // return agencias.removeIf(agencia -> agencia.getId().equals(id));
    }

    public void alterar(Agencia agencia) {
        // ninguém merece copiar campo a campo.
        if (!agenciaRepository.isPersistent(agencia)) {
            throw new PersistenceException("Entidade não gerenciada");
        }
        // força o Hibernate a aplicar o UPDATE agora
        agenciaRepository.flush();
    }

}