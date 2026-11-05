package com.veterinariasm.compra.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veterinariasm.compra.model.SerCarrito;

@Repository 
public interface SerCarritoRepo extends JpaRepository<SerCarrito,Integer>{

}
