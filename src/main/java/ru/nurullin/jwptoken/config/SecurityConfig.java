package ru.nurullin.jwptoken.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {

    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/api/v1/auth/login").permitAll()
                        .requestMatchers("/api/v1/admin/**").hasRole("ROLE_ADMIN")
                        .requestMatchers("/api/v1/reporter/**").hasRole("ROLE_REPORTER")
                        .requestMatchers("/api/v1/spectator/**").hasRole("ROLE_SPECTATOR")
                        .anyRequest()
                        .authenticated());
        return http.build();
    }
}
