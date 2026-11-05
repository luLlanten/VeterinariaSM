package com.veterinariasm.citas.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veterinariasm.citas.model.CitaHistorial;

@Repository 
public interface CitaHistorialRepo extends JpaRepository<CitaHistorial, Integer> {

}
