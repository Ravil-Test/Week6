package ru.nurullin.jwptoken.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nurullin.jwptoken.model.Reporter;

import java.util.Optional;

public interface ReporterRepository extends JpaRepository<Reporter, Long> {
    Optional<Reporter> findByEmail(String email);
}
