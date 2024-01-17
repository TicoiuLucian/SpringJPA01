package ro.itschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.itschool.entity.Pokemon;

import java.util.List;
import java.util.UUID;

public interface PokemonRepository extends JpaRepository<Pokemon, UUID> {

  List<Pokemon> findByNameContaining(String name);

  List<Pokemon> findByLocationContaining(String location);

  List<Pokemon> findByNameContainingAndLocationContaining(String name, String location);
}
