package br.dev.juniorlatalisa.screenmatch.principal;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.dev.juniorlatalisa.screenmatch.model.DadosSerie;
import br.dev.juniorlatalisa.screenmatch.model.DadosTemporada;
import br.dev.juniorlatalisa.screenmatch.service.ConsumoAPI;
import br.dev.juniorlatalisa.screenmatch.service.ConverteDados;

@Service
public class Principal {

    private final String omdbHostBase = "https://www.omdbapi.com/?t=%s&apikey=%s";
    private final ConsumoAPI consumoApi = new ConsumoAPI();
    private final ConverteDados converteDados = new ConverteDados();
    private final List<DadosTemporada> temporadas = new ArrayList<>();

    @Value("${omdb.api.key}")
    private String apiKey;

    // Ter o nome da Série independente da formatação para consulta da API
    private String nomeSerie;
    private DadosSerie dadosSerie;

    public void solicitarNomeSerie() {
        System.out.print("Digite o nome da série para busca: ");
        this.nomeSerie = nextLine();
    }

    public void solicitarDadosSerie() {
        final var endereco = montarUrlApi();
        final var json = obterDados(endereco);
        dadosSerie = converteDados.obterDados(DadosSerie.class, json);
    }

    public void solicitarDadosTemporada() {
        for (int i = 1; i <= dadosSerie.totalTemporadas(); i++) {
            temporadas.add(solicitarDadosTemporada(i));
        }
    }

    public void exibirDadosSerie() {
        System.out.println(dadosSerie);
    }

    public void exibirDadosTemporada() {
        temporadas.forEach(System.out::println);
    }

    private DadosTemporada solicitarDadosTemporada(final int temporada) {
        final var endereco = montarUrlApi().concat(String.format("&season=%s", temporada));
        final var json = obterDados(endereco);
        return converteDados.obterDados(DadosTemporada.class, json);
    }

    private String obterDados(final String endereco) {
        System.out.println(String.format("Solicitando dados em [%s]...", endereco));
        return consumoApi.obterDados(endereco);
    }

    private String montarUrlApi() {
        return String.format(omdbHostBase, URLEncoder.encode(nomeSerie, StandardCharsets.UTF_8), apiKey);
    }

    private String nextLine() {
        try (final var scanner = new Scanner(System.in)) {
            return scanner.nextLine();
        }
    }

}
