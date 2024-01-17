package ro.itschool.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Pokemon {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id; //Universally Unique IDentifier = 36-character alphanumeric string that can be used to identify
  // information

  private String name;

  private String location;

  private Integer age;

  @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  private Trainer trainer;

  public Pokemon(final String name, final String location, final Integer age) {
    this.name = name;
    this.location = location;
    this.age = age;
  }

  public Pokemon(final String name, final String location, final Integer age, final Trainer trainer) {
    this.name = name;
    this.location = location;
    this.age = age;
    this.trainer = trainer;
  }

  @Override
  public String toString() {
    return "\n" + "Pokemon{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", location='" + location + '\'' +
            ", age=" + age +
            '}';
  }
}
