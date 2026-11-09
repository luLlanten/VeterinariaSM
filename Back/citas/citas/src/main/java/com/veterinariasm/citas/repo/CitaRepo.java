package com.veterinariasm.citas.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veterinariasm.citas.model.Cita;

@Repository 
public interface CitaRepo extends JpaRepository <Cita, Integer> {
    List<Cita> findByIdUsuario(Integer idUsuario);
}
