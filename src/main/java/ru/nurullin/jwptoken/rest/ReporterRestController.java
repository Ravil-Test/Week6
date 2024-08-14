package ru.nurullin.jwptoken.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nurullin.jwptoken.model.Reporter;
import ru.nurullin.jwptoken.repository.ReporterRepository;

import java.util.List;


@RestController
@RequestMapping("/api/v1/reporter/")
public class ReporterRestController {

    private final ReporterRepository reporterRepository;

    @Autowired
    public ReporterRestController(ReporterRepository adminRepository) {
        this.reporterRepository = adminRepository;
    }

    @GetMapping
    public List<Reporter> findAll() {
        return reporterRepository.findAll();
    }
}
