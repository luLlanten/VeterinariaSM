package com.veterinariasm.ficha.config;

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
                .title("VeterinariaSM - Microservicio Fichas clínicas")
                .version("1.0")
                .description("Mascotas, fichas clínicas y necropsias. Se accede directamente por el puerto 8084 o a través del API Gateway (puerto 9090).")
                .contact(new Contact().name("Equipo VeterinariaSM")));
    }
}
