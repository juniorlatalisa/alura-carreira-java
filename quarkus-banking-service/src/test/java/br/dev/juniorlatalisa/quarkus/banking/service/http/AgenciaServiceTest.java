package br.dev.juniorlatalisa.quarkus.banking.service.http;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.dev.juniorlatalisa.quarkus.banking.domain.Agencia;
import br.dev.juniorlatalisa.quarkus.banking.domain.exceptions.AgenciaNaoAtivaOuNaoEncontradaException;
import br.dev.juniorlatalisa.quarkus.banking.repository.AgenciaRepository;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class AgenciaServiceTest {

    @InjectMock
    private AgenciaRepository agenciaRepository;

    @InjectMock
    @RestClient
    private SituacaoCadastralHttpService situacaoCadastralHttpService;

    @Inject
    private AgenciaService agenciaService;

    // Código omitido

    @Test
    public void deveNaoCadastrarQuandoClientRetornarNull() {
        Mockito.when(situacaoCadastralHttpService.buscarPorCnpj("123")).thenReturn(null);

        final var agencia = createAgencia();

        Assertions.assertThrows(AgenciaNaoAtivaOuNaoEncontradaException.class, () -> agenciaService.cadastrar(agencia));

        Mockito.verify(agenciaRepository, Mockito.never()).persist(agencia);
    }

    private Agencia createAgencia() {
        return new Agencia();
    }

}
