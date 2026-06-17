package br.dev.juniorlatalisa.screenmatch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.dev.juniorlatalisa.screenmatch.model.DadosEpisodio;
import br.dev.juniorlatalisa.screenmatch.model.DadosSerie;
import br.dev.juniorlatalisa.screenmatch.model.DadosTemporada;
import br.dev.juniorlatalisa.screenmatch.service.ConsumoAPI;
import br.dev.juniorlatalisa.screenmatch.service.ConverteDados;

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
		var json = consumoApi.obterDados(String //
				.format("https://www.omdbapi.com/?t=gilmore+girls&apikey=%s", apiKey));
		final var conversor = new ConverteDados();
		final var serie = conversor.obterDados(DadosSerie.class, json);
		// final var json =
		// consumoAPI.obterDados("https://coffee.alexflipnote.dev/random.json");
		System.out.println(serie);

		json = consumoApi.obterDados(String //
				.format("https://www.omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=%s", apiKey));

		final var episodio = conversor.obterDados(DadosEpisodio.class, json);
		System.out.println(episodio);

		final List<DadosTemporada> temporadas = new ArrayList<>(serie.totalTemporadas());
		for (int i = 1; i <= serie.totalTemporadas(); i++) {
			json = consumoApi.obterDados(String //
					.format("https://www.omdbapi.com/?t=gilmore+girls&season=%s&apikey=%s", i, apiKey));
			final var temporada = conversor.obterDados(DadosTemporada.class, json);
			System.out.println(temporada);
		}
		temporadas.forEach(System.out::println);
	}

}
