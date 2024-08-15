package ru.nurullin.jwptoken.security.jwt;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import ru.nurullin.jwptoken.model.Reporter;
import ru.nurullin.jwptoken.model.Role;
import ru.nurullin.jwptoken.model.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class JwtReporterFactory {

    public JwtReporterFactory() {
    }

    public static JwtReporter create(Reporter reporter) {
        return new JwtReporter(
                reporter.getId(),
                reporter.getName(),
                reporter.getAge(),
                reporter.getDescription(),
                reporter.getTelNumber(),
                reporter.getEmail(),
                reporter.getStatus().equals(Status.ACTIVE),
                mapToGrantedAuthorities(new ArrayList<>(reporter.getRoles()))
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> reporterRoles) {
        return reporterRoles.stream().map(role ->
                new SimpleGrantedAuthority(role.getName())
        ).collect(Collectors.toList());
    }

}
