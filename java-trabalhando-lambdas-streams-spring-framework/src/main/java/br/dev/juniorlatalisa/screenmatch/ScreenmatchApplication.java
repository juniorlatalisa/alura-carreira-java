package br.dev.juniorlatalisa.screenmatch;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.dev.juniorlatalisa.screenmatch.service.ConsumoAPI;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	@Value("${omdb.api.key}")
	private String apiKey;

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		final var consumoApi = new ConsumoAPI();
		var json = consumoApi.obterDados(String.format("https://www.omdbapi.com/?t=gilmore+girls&apikey=%s", apiKey));
		// final var json =
		// consumoAPI.obterDados("https://coffee.alexflipnote.dev/random.json");
		System.out.println(json);
	}

}
