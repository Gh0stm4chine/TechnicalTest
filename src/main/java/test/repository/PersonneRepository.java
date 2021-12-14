package test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.domain.model.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
}