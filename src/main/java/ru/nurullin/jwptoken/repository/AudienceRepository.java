package ru.nurullin.jwptoken.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nurullin.jwptoken.model.Audience;

import java.util.Optional;

public interface AudienceRepository extends JpaRepository<Audience, Long> {
    Optional<Audience> findByName(String name);
}
