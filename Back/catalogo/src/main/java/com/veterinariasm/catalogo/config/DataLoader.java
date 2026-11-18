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
                Servicios s1 = repo.save(new Servicios(null,"Consultas","Consulta general",15000.0,"/images/consulta-general.jpg"));
                Servicios s2 = repo.save(new Servicios(null,"Consultas","Consulta urgencia",25000.0,"/images/consulta-urgencia.jpg"));
                Servicios s3 = repo.save(new Servicios(null,"Consultas","Control postoperatorio",10000.0,"/images/control-postoperatorio.jpg"));
                Servicios s4 = repo.save(new Servicios(null,"Consultas","Consulta ave/conejo",18000.0,"/images/consulta-ave-conejo.jpg"));
                Servicios s5 = repo.save(new Servicios(null,"Consultas","Segunda opinión médica",20000.0,"/images/segunda-opinion-medica.jpg"));
                Servicios s6 = repo.save(new Servicios(null,"Cirugía","Esterilización hembra canina",80000.0,"/images/esterilizacion-hembra-canina.jpg"));
                Servicios s7 = repo.save(new Servicios(null,"Cirugía","Esterilización macho canino",60000.0,"/images/esterilizacion-macho-canino.jpg"));
                Servicios s8 = repo.save(new Servicios(null,"Cirugía","Esterilización hembra felina",65000.0,"/images/esterilizacion-hembra-felina.jpg"));
                Servicios s9 = repo.save(new Servicios(null,"Cirugía","Esterilización macho felino",50000.0,"/images/esterilizacion-macho-felino.jpg"));
                Servicios s10 = repo.save(new Servicios(null,"Cirugía","Extirpación de tumor cutáneo",120000.0,"/images/extirpacion-de-tumor-cutaneo.jpg"));
                Servicios s11 = repo.save(new Servicios(null,"Cirugía","Cesárea de urgencia",180000.0,"/images/cesarea-de-urgencia.png"));
                Servicios s12 = repo.save(new Servicios(null,"Desparasitación","Desparasitación interna pequeños (<10 kg)",8000.0,"/images/desparasitacion-interna-pequenos-0-kg.jpg"));
                Servicios s13 = repo.save(new Servicios(null,"Desparasitación","Desparasitación interna medianos (10-25 kg)",9500.0,"/images/desparasitacion-interna-medianos.jpg"));
                Servicios s14 = repo.save(new Servicios(null,"Desparasitación","Desparasitación interna grandes (>25 kg)",11000.0,"/images/desparasitacion-interna-grandes.jpg"));
                Servicios s15 = repo.save(new Servicios(null,"Desparasitación","Desparasitación interna felina",8000.0,"/images/desparasitacion-interna-felina.jpg"));
                Servicios s16 = repo.save(new Servicios(null,"Desparasitación","Antiparasitario externo (pipeta)",180000.0,"/images/cesarea-de-urgencia.png"));
                Servicios s17 = repo.save(new Servicios(null,"Desparasitación","Hemograma completo",180000.0,"/images/cesarea-de-urgencia.png"));
                Servicios s18 = repo.save(new Servicios(null,"Desparasitación","Perfil bioquímico completo",180000.0,"/images/cesarea-de-urgencia.png"));
                Servicios s19 = repo.save(new Servicios(null,"Desparasitación","Cesárea de urgencia",180000.0,"/images/cesarea-de-urgencia.png"));
                Servicios s20 = repo.save(new Servicios(null,"Desparasitación","Cesárea de urgencia",180000.0,"/images/cesarea-de-urgencia.png"));


            }
        };
    }

}
