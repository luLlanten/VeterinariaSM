package com.veterinariasm.compra.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veterinariasm.compra.model.Boleta;
import com.veterinariasm.compra.model.Carrito;

@Repository 
public interface BoletaRepo extends JpaRepository<Boleta,Integer>{
    List<Boleta> findByCarrito(Carrito carrito);
}
