package br.dev.juniorlatalisa.quarkus.banking.service.http;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.dev.juniorlatalisa.quarkus.banking.domain.http.AgenciaHttp;

@Path("/situacao-cadastral")
@RegisterRestClient(configKey = "situacao-cadastral-api")
public interface SituacaoCadastralHttpService {

    @GET
    @Path("{cnpj}")
    AgenciaHttp buscarPorCnpj(@PathParam("cnpj") String cnpj);

}
