package com.veterinariasm.ficha.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.veterinariasm.ficha.model.Necropsia;

@Repository 
public interface NecropsiaRepo extends JpaRepository<Necropsia,Integer> {
    Necropsia findByIdMascota(Integer idMascota);
    List<Necropsia> findByIdUsuario(Integer idUsuario);
}
