package com.veterinariasm.cliente_lobby.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veterinariasm.cliente_lobby.model.Admin;

@Repository 
public interface AdminRepo extends JpaRepository<Admin,Integer>{
    Admin findByCorreo(String correo);
}
