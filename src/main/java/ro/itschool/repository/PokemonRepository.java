package ro.itschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.itschool.entity.Pokemon;

import java.util.List;
import java.util.UUID;

public interface PokemonRepository extends JpaRepository<Pokemon, UUID> {

  List<Pokemon> findByNameContaining(String name);

  List<Pokemon> findByLocationContaining(String location);

  List<Pokemon> findByNameContainingAndLocationContaining(String name, String location);

  //JPQL = Java Persistence Query Language (JPQL)
  @Query(value = "Select p from Pokemon p order by age, name")
  List<Pokemon> findAllPokemonsSortedByAgeAndName();

  //SQL = Structured query language
  @Query(value = "Select * from Pokemon order by age, name", nativeQuery = true)
  List<Pokemon> findAllPokemonsSortedByAgeAndNameNativeQuery();

  List<Pokemon> findAllByOrderByAgeAscNameDesc();
}
