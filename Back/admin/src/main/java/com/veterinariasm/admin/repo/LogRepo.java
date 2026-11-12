package com.veterinariasm.admin.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veterinariasm.admin.model.Log;

@Repository
public interface LogRepo extends JpaRepository<Log,Integer> {
    List<Log>findByAdminId(Integer id);
    List<Log>findByRuta(String ruta);
}
