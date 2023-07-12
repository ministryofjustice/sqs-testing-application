package uk.gov.justice.laa.crime.microservice.sqstester.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Value("${app.api_username}")
    private String apiUsername;
    @Value("${app.api_password}")
    private String apiPassword;

    /**
     * Allow a user to gain access with a username and password
     *
     * @param passwordEncoder Encodes the provided password
     * @return The user using an in-memory database
     */
    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.withUsername(this.apiUsername)
                .password(this.apiPassword)
                .build();

        return new InMemoryUserDetailsManager(user);
    }

    /**
     * Protect the specified path with HttpBasic authentication
     *
     * @param http Configure security for the request
     * @return An object with Http security configured
     * @throws Exception Throws an exception
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .requestMatchers("/send-message")
                .authenticated()
                .and()
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }


    /**
     * Encodes passwords
     *
     * @return A password encoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return encoder;
    }
}
