package ro.itschool;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.itschool.entity.Pokemon;
import ro.itschool.entity.Trainer;
import ro.itschool.repository.TrainerRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootApplication
public class Main {
  private final Faker faker = new Faker();

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }

  @Bean
  public CommandLineRunner runMe(TrainerRepository trainerRepository) {
    return (args) -> {
//      saveTrainersAndPokemons(trainerRepository);
      System.out.println(trainerRepository.findByFirstName("Gertrud"));
    };
  }

  private void saveTrainersAndPokemons(TrainerRepository trainerRepository) {

    IntStream.rangeClosed(0, 5).forEach(position -> {
      Trainer trainer = getTrainer();
      trainerRepository.save(trainer);
    });
  }

  private Trainer getTrainer() {
    Trainer trainer = new Trainer();
    trainer.setBirthDate(generateBirthDate());
    trainer.setFirstName(faker.name().firstName());
    trainer.setLastName(faker.name().lastName());
    trainer.setPokemons(getPokemons(trainer));
    return trainer;
  }

  private List<Pokemon> getPokemons(Trainer trainer) {
    List<Pokemon> pokemons = new ArrayList<>();
    IntStream.rangeClosed(0, faker.number().numberBetween(3, 10)).forEach(pos -> pokemons.add(new Pokemon(faker.pokemon().name(), faker.pokemon().location(), faker.number().numberBetween(1, 100), trainer)));
    return pokemons;
  }

  private LocalDate generateBirthDate() {
    Date birthDate = this.faker.date().between(
            java.sql.Date.valueOf(LocalDate.of(1990, 1, 1)),
            java.sql.Date.valueOf(LocalDate.of(1995, 12, 31)));
    return birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
  }
}