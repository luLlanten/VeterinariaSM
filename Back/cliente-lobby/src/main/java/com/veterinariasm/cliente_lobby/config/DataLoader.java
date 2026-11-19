package com.veterinariasm.cliente_lobby.config;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.veterinariasm.cliente_lobby.model.Admin;
import com.veterinariasm.cliente_lobby.model.User;
import com.veterinariasm.cliente_lobby.repo.AdminRepo;
import com.veterinariasm.cliente_lobby.repo.UserRepo;

@Configuration 
public class DataLoader {
    @Bean 
    CommandLineRunner initUserDataBase(UserRepo repo){
        return args->{
            if (repo.count()==0){
                User veterinario=repo.save(new User(null, "Mariano", "Elizalde", true, true, "Calle las matas 123", 88888888, new Date(), "ma.eliz@sanmarcos.cl", "12345678"));
                User cliente=repo.save(new User(null, "Brandon", "Banda", false, true, "Av las peras 666", 44444444, new Date(), "brandon@gmail.com", "00000000"));
            }
        };
    }
    @Bean 
    CommandLineRunner initAdminDataBase(AdminRepo repo){
        return args->{
            if(repo.count()==0){
                Admin admin=repo.save(new Admin(null,"Lukas","Llanten",77777777,new Date(),"admin@sanmarcos.cl","aaaaaaaa",true));
            }
        };
    }
}
