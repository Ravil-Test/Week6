package ru.nurullin.jwptoken.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.nurullin.jwptoken.model.Reporter;
import ru.nurullin.jwptoken.model.Role;
import ru.nurullin.jwptoken.model.Status;
import ru.nurullin.jwptoken.repository.ReporterRepository;
import ru.nurullin.jwptoken.repository.RoleRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ReporterService {

    private final ReporterRepository reporterRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public ReporterService(ReporterRepository reporterRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.reporterRepository = reporterRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Reporter register(Reporter reporter) {
        Role roleReporter = roleRepository.findByName("ROLE_REPORTER");
        List<Role> reporterRoles = new ArrayList<>();
        reporterRoles.add(roleReporter);

        reporter.setTelNumber(passwordEncoder.encode(reporter.getTelNumber()));
        reporter.setRoles(reporterRoles);
        reporter.setStatus(Status.ACTIVE);

        Reporter redisteredReporter = reporterRepository.save(reporter);

        log.info("IN register - reporter: {} successfully registered", redisteredReporter);

        return redisteredReporter;
    }

    public List<Reporter> findAll() {
        List<Reporter> result = reporterRepository.findAll();
        log.info("IN findAll - {} reporters found", result.size());
        return result;
    }

    public Reporter findByEmail(String email) {
        Reporter result = reporterRepository.findByEmail(email);
        log.info("IN findByEmail - reporter: {} found by email: {}", result, email);
        return result;
    }

    public Reporter findById(Long id) {
        Reporter result = reporterRepository.findById(id).orElse(null);

        if (result == null) {
            log.warn("IN findById - no user found by id: {}", id);
            return null;
        }

        log.info("IN findById - reporter: {} found by id", result);
        return result;
    }

    public void delete(Long id) {
        reporterRepository.deleteById(id);
        log.info("IN delete - reporter with id: {} successfully deleted", id);
    }
}
