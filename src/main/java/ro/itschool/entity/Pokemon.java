package ro.itschool.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class Pokemon {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id; //Universally Unique IDentifier = 36-character alphanumeric string that can be used to identify
  // information

  private String name;

  private String location;

  private Integer age;

  public Pokemon(final String name, final String location, final Integer age) {
    this.name = name;
    this.location = location;
    this.age = age;
  }
}
