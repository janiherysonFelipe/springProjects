package br.imd.ufrn.alunoIMD.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig{

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(autorized -> autorized
                        .requestMatchers(HttpMethod.POST, "/alunos").hasRole("ADMIN")
                        .anyRequest().authenticated()

                )
                .build();

               /* .authorizeHttpRequests(
                     authorizeConfig -> {
                         authorizeConfig.requestMatchers("/public").permitAll();
                         authorizeConfig.requestMatchers("/logout").permitAll();
                         authorizeConfig.anyRequest().authenticated();
                     })
                .formLogin(Customizer.withDefaults())
                .build();

                 */
    }
}
