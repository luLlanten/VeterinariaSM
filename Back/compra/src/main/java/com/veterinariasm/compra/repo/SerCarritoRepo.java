package com.veterinariasm.compra.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veterinariasm.compra.model.Carrito;
import com.veterinariasm.compra.model.SerCarrito;

@Repository 
public interface SerCarritoRepo extends JpaRepository<SerCarrito,Integer>{
    List<SerCarrito> findByCarrito(Carrito carrito);
}
