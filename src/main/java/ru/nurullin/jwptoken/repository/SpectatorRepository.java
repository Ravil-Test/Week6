package ru.nurullin.jwptoken.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nurullin.jwptoken.model.Spectator;

import java.util.Optional;

public interface SpectatorRepository extends JpaRepository<Spectator, Long> {
    Optional<Spectator> findByTelNumber(long telNumber);
}
