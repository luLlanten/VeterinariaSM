package com.veterinariasm.catalogo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veterinariasm.catalogo.model.Servicios;

@Repository 
public interface ServRepo extends JpaRepository<Servicios,Integer>{

}
