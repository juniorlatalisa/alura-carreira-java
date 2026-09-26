package br.dev.juniorlatalisa.quarkus.banking.controller;

import java.util.List;

import org.jboss.resteasy.reactive.RestResponse;

import br.dev.juniorlatalisa.quarkus.banking.domain.Agencia;
import br.dev.juniorlatalisa.quarkus.banking.service.http.AgenciaService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;

@Path("/agencias")
public class AgenciaController {

    public AgenciaController(AgenciaService agenciaService) {
        this.agenciaService = agenciaService;
    }

    @Inject
    private final AgenciaService agenciaService;

    @POST
    @Transactional
    public RestResponse<Void> cadastrar(Agencia agencia, @Context UriInfo uriInfo) {
        agenciaService.cadastrar(agencia);
        return RestResponse.created(uriInfo.getAbsolutePath());
    }

    @GET
    public RestResponse<List<Agencia>> buscarTodas() {
        final var agencias = this.agenciaService.listarTodas();
        return RestResponse.ok(agencias);
    }

    @GET
    @Path("{id}")
    public RestResponse<Agencia> buscarPorId(Integer id) {
        final var agencia = this.agenciaService.buscarPorId(id);
        return RestResponse.ok(agencia);
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public RestResponse<Void> deletar(Integer id) {
        final var sucesso = this.agenciaService.deletar(id);
        return sucesso ? RestResponse.ok() : RestResponse.notFound();
    }

    @PUT
    @Transactional
    public RestResponse<Void> alterar(Agencia agencia) {
        this.agenciaService.alterar(agencia);
        return RestResponse.ok();
    }

}