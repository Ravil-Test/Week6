package ru.nurullin.jwptoken.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.nurullin.jwptoken.model.Reporter;
import ru.nurullin.jwptoken.security.jwt.JwtReporter;
import ru.nurullin.jwptoken.security.jwt.JwtReporterFactory;
import ru.nurullin.jwptoken.service.ReporterService;

@Service
@Slf4j
public class JwtReporterDetailsService implements UserDetailsService {

    private final ReporterService reporterService;

    @Autowired
    public JwtReporterDetailsService(ReporterService reporterService) {
        this.reporterService = reporterService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Reporter reporter = reporterService.findByEmail(email);

        if (reporter == null) {
            throw new UsernameNotFoundException("Reporter not found");
        }

        JwtReporter jwtReporter = JwtReporterFactory.create(reporter);
        log.info("IN loadReporterByEmail - reporter with email: {} successful loaded", email);

        return jwtReporter;
    }
}
