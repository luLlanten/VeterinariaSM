package com.veterinariasm.admin.config;

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
                .title("VeterinariaSM - Microservicio Administración")
                .version("1.0")
                .description("Gestión del catálogo y de roles por parte del administrador, y bitácora de acciones. Se accede directamente por el puerto 8083 o a través del API Gateway (puerto 9090).")
                .contact(new Contact().name("Equipo VeterinariaSM")));
    }
}
