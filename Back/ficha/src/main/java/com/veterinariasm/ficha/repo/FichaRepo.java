package com.veterinariasm.ficha.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veterinariasm.ficha.model.Ficha;

@Repository 
public interface FichaRepo extends JpaRepository<Ficha, Integer>{

}
