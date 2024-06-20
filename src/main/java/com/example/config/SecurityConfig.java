package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws  Exception{
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> request
                        .requestMatchers(HttpMethod.POST,"login/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "username/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/usuario/**").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest()
                        .authenticated()
                ).httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("userAdmin")
                .password(passwordEncoder().encode("0102"))
                .roles("ADMIN")
                .build();
        UserDetails gerente = User.builder()
                .username("userGerente")
                .password(passwordEncoder().encode("0102"))
                .roles("GERENTE")
                .build();
        UserDetails vendedor = User.builder()
                .username("userVendedor")
                .password(passwordEncoder().encode("0102"))
                .roles("VENDEDOR")
                .build();
        UserDetails cliente = User.builder()
                .username("userCliente")
                .password(passwordEncoder().encode("0102"))
                .roles("CLIENTE")
                .build();
        return new InMemoryUserDetailsManager(user, gerente, vendedor, cliente);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}