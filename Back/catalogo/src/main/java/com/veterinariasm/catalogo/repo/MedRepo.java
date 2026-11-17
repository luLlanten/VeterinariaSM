package com.veterinariasm.catalogo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veterinariasm.catalogo.model.Medicamento;

@Repository 
public interface MedRepo extends JpaRepository<Medicamento,Integer>{
    
}
