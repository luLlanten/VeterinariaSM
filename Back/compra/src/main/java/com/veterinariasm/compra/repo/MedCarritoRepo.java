package com.veterinariasm.compra.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veterinariasm.compra.model.Carrito;
import com.veterinariasm.compra.model.MedCarrito;;

@Repository 
public interface MedCarritoRepo extends JpaRepository<MedCarrito,Integer> { 
    List<MedCarrito> findByCarrito(Carrito carrito);
}
