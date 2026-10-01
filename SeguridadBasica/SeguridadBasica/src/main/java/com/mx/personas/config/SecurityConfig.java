package com.mx.personas.config;

import org.springframework.context.annotation.*;
import org.springframework.security.config.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.web.*;

@Configuration
public class SecurityConfig {

    //Metodo que se encarga de los filtros de seguridad de Spring security
    @Bean //Indica que cada instancia sera gestionada por el contenedor de Spring
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http
                //CSRF es un tipo de ataque donde el usuario autenticado realiza acciones sin
                //darse cuenta.
                //Deshabilitamos la proteccion csrf porque no usamos formulario login.
                .csrf(csrf -> csrf.disable())
                //AUTORIZACION DE PETICIONES
                //Definimos las reglas de autenticacion para las solicitudes HTTP
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated()//Indica que cualquier peticion HTTP requiere autenticacion.
                                                    //No hay endpoints publicos.
                )
                //METODO DE AUTENTICACION
                //Habilitamos la autenticacion basica
                .httpBasic(Customizer.withDefaults());
        //Retornamos y construimos el filtro de seguridad con todas las
        //configuraciones realizadas.
        return http.build();
    }
}
