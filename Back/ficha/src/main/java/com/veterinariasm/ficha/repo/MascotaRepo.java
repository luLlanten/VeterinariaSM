package com.veterinariasm.ficha.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veterinariasm.ficha.model.Mascota;

@Repository 
public interface MascotaRepo extends JpaRepository<Mascota,Integer> {
    List<Mascota> findByIdUsuario(Integer idUsuario);
}
