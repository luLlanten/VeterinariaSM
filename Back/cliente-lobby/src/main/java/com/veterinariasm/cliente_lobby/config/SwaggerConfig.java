package com.veterinariasm.cliente_lobby.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("VeterinariaSM - Microservicio Usuarios y administradores")
                .version("1.0")
                .description("Registro, inicio de sesión, perfil y recuperación de contraseña de clientes, veterinarios y administradores. Se accede directamente por el puerto 8079 o a través del API Gateway (puerto 9090).")
                .contact(new Contact().name("Equipo VeterinariaSM")));
    }
}
