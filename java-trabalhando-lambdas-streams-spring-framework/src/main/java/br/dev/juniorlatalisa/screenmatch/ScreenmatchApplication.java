package br.dev.juniorlatalisa.screenmatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.dev.juniorlatalisa.screenmatch.principal.Principal;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	private final Principal principal;

	public ScreenmatchApplication(Principal principal) {
		this.principal = principal;
	}

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		principal.solicitarNomeSerie();
		principal.solicitarDadosSerie();
		principal.exibirDadosSerie();
		principal.solicitarDadosTemporada();
		principal.exibirDadosTemporada();
	}
}
