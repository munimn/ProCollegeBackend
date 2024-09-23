package edu.lawrence.college.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    JwtAuthFilter jwtAuthFilter;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	http
        .csrf(csrf -> csrf.disable())
        .sessionManagement(management -> management
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(authorize -> authorize.requestMatchers(HttpMethod.POST, "/users", "/users/login","/question").permitAll()
        		.requestMatchers(HttpMethod.GET, "/profile","/profile/{collegeid}","/college/{collegeid}","/college","/college/name/{college}",
        				"/question","/question/{userid}","/answer/{userid}","/academics/college/{collegeid}","/academics/{collegeid}","/studentlife/college/{collegeid}","/studentlife/{collegeid}","/finances/college/{collegeid}","/finances/{collegeid}").permitAll()
        		.requestMatchers("/swagger-ui/**", "/swagger-resources/*", "/v3/api-docs/**").permitAll()
                .anyRequest().authenticated()
                )
        .addFilterBefore( jwtAuthFilter, UsernamePasswordAuthenticationFilter.class); 
        return http.build();
    }

}

