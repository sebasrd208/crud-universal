package com.mx.usuarios.config;

import org.springframework.security.web.*;
import org.springframework.context.annotation.*;
import org.springframework.security.config.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;


@Configuration
@EnableWebSecurity
public class SecuriryConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        //Acceso libre para cualquier endpoint después del path /usuarios
                        .requestMatchers("/usuarios/**").permitAll()
                        .requestMatchers("/noticias").permitAll()
                        //Solo los usuarios autenticados con ROL_USER pueden acceder a este endpoint
                        .requestMatchers("/cuenta").hasRole("USER")
                        //Solo los usuarios autenticados con ROL_ADMIN pueden acceder a este endpoint
                        .requestMatchers("/config").hasRole("ADMIN")
                        //Los usuarios autenticados con ROL_USER o ROL_ADMIN pueden acceder a este endpoint
                        .requestMatchers("/contacto").hasAnyRole("USER", "ADMIN")
                        //Cualquier otra ruta que no esté configurada necesita autenticación
                        .anyRequest().authenticated()).httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
