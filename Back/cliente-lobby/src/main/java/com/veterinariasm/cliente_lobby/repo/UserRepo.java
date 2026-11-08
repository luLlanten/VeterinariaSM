package com.veterinariasm.cliente_lobby.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veterinariasm.cliente_lobby.model.User;

@Repository 
public interface UserRepo extends JpaRepository<User,Integer>{
    User findByCorreo(String correo);
}
