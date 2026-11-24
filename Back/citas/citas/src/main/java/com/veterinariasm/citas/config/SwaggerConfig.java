package com.veterinariasm.citas.config;

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
                .title("VeterinariaSM - Microservicio Citas")
                .version("1.0")
                .description("Agendamiento, modificación, cancelación e historial de citas. Se accede directamente por el puerto 8081 o a través del API Gateway (puerto 9090).")
                .contact(new Contact().name("Equipo VeterinariaSM")));
    }
}
