package grandvoyage.software.project.EncryptionConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Create a PasswordEncoder bean
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Security configuration
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Disable CSRF for H2 console
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll()  // Allow access to H2 console
                        .anyRequest().authenticated()  // Authenticate all other requests
                )
                .formLogin(form -> form.disable())  // Disable default form login
                .httpBasic(basic -> basic.disable())  // Disable HTTP Basic authentication
                .headers(headers -> headers
                        .frameOptions(frameOptions -> frameOptions.disable())  // Disable frame options to allow H2 console in iframe
                );  // Allow use of frames (needed for H2 console)

        return http.build();
    }
}
