package ru.nurullin.jwptoken.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nurullin.jwptoken.model.Reporter;

public interface ReporterRepository extends JpaRepository<Reporter, Long> {
    Reporter findByEmail(String email);
}
