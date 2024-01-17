package ro.itschool.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class Trainer {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id; //Universally Unique IDentifier = 36-character alphanumeric string that can be used to identify
  // information

  private String firstName;

  private String lastName;

  private LocalDate birthDate;

  @OneToMany(mappedBy = "trainer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private List<Pokemon> pokemons = new ArrayList<>();
}
