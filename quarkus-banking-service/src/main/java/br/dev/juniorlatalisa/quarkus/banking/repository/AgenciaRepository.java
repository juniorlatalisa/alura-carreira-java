package br.dev.juniorlatalisa.quarkus.banking.repository;

import br.dev.juniorlatalisa.quarkus.banking.domain.Agencia;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AgenciaRepository implements PanacheRepository<Agencia> {
}