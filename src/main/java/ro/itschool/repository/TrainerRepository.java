package ro.itschool.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import ro.itschool.entity.Trainer;

import java.util.Optional;
import java.util.UUID;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {

  Optional<Trainer> findByFirstName(String firstName);

  @Modifying
  @Transactional
  void removeByFirstName(String firstName);
}
