package com.veterinariasm.catalogo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.veterinariasm.catalogo.model.Servicios;
import com.veterinariasm.catalogo.repo.ServRepo;

@Configuration 
public class DataLoader {
    @Bean 
    CommandLineRunner initServicioDataBase(ServRepo repo){
        return args->{
            if (repo.count() == 0) {
                Servicios s1 = repo.save(new Servicios(null,"Consultas","Consulta general",15000.0));
                Servicios s2 = repo.save(new Servicios(null,"Consultas","Consulta urgencia",15000.0));
                Servicios s3 = repo.save(new Servicios(null,"Consultas","Consulta general",15000.0));
                Servicios s4 = repo.save(new Servicios(null,"Consultas","Consulta general",15000.0));
                Servicios s5 = repo.save(new Servicios(null,"Consultas","Consulta general",15000.0));
            }
        };
    }

}
