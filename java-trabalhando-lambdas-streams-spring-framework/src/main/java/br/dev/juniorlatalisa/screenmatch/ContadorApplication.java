package br.dev.juniorlatalisa.screenmatch;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication
public class ContadorApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ContadorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Bem vindo ao contador!");
        System.out.println("----------------------");
        System.out.println("Digite um número para contagem: ");
        final int numero;
        try (final var entrada = new Scanner(System.in)) {
            numero = entrada.nextInt();
        }
        for (int i = 1; i <= numero; i++) {
            System.out.print(i + " ");
        }
    }
}
