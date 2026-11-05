package com.veterinariasm.compra.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veterinariasm.compra.model.MedCarrito;

@Repository 
public interface MedCarritoRepo extends JpaRepository<MedCarrito,Integer> {

}
