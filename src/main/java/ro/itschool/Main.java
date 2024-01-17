package ro.itschool;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.itschool.entity.Pokemon;
import ro.itschool.repository.PokemonRepository;

import java.util.stream.IntStream;

@SpringBootApplication
public class Main {
  private final Faker faker = new Faker();

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }

  @Bean
  public CommandLineRunner runMe(PokemonRepository pokemonRepository) {
    return (args) -> {
//      savePokemons(pokemonRepository);
      System.out.println(pokemonRepository.findByNameContainingAndLocationContaining("ddi", "eterna"));
    };
  }

  private void savePokemons(PokemonRepository pokemonRepository) {
    IntStream.rangeClosed(0, 100).forEach(position -> pokemonRepository.save(new Pokemon(
            faker.pokemon().name(),
            faker.pokemon().location(),
            faker.number().numberBetween(1, 100))));
  }
}