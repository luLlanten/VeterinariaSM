package com.veterinariasm.citas.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veterinariasm.citas.model.CitaServicio;

@Repository 
public interface CitaServicioRepo extends JpaRepository<CitaServicio, Integer> {

}
