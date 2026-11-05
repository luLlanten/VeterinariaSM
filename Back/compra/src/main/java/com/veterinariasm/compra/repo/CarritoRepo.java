package com.veterinariasm.compra.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veterinariasm.compra.model.Carrito;

@Repository 
public interface CarritoRepo extends JpaRepository<Carrito,Integer> {
    Carrito findByUsuarioId(Integer id);
}
