package com.veterinariasm.cliente_lobby.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration 
public class Seguridad {
    @Bean 
    public PasswordEncoder passwordEncode(){
        return new BCryptPasswordEncoder();
    }


    //Desactivamos seguridad automatica 
    public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
        http.csrf(csrf->csrf.disable()).authorizeHttpRequests(auth->auth.anyRequest().permitAll());
        //el csrf se encarga de que el usuario solo acceda a la informacion desde un unico sitio, lo desactivamos para facilitar la conexion y uso
        //de esta forma, se permite el ingreso de todas las peticiones http
        return http.build();
    }

}
