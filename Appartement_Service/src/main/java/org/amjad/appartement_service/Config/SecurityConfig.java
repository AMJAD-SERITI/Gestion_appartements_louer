package org.amjad.appartement_service.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;*/

@Configuration
//@EnableWebSecurity
public class SecurityConfig {

/*    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests((authorize) -> authorize
                .requestMatchers("/auth/register","/api/appartements/getAll", "/api/appartemenwts/create", "/api/appartements/delete/**").permitAll()
                .anyRequest().authenticated()
        );
        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/
}
