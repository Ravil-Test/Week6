package ru.nurullin.jwptoken.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nurullin.jwptoken.model.Report;

import java.util.Optional;

public interface ReportRepository extends JpaRepository <Report, Long> {
    Optional<Report> findByName(String name);
}
