package com.veterinariasm.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veterinariasm.admin.model.Log;

@Repository
public interface LogRepo extends JpaRepository<Log,Integer> {
    
}
