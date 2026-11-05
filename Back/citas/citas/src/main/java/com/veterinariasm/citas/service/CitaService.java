package com.veterinariasm.citas.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinariasm.citas.dto.ServicioDTO;
import com.veterinariasm.citas.model.Cita;
import com.veterinariasm.citas.model.CitaHistorial;
import com.veterinariasm.citas.model.CitaServicio;
import com.veterinariasm.citas.repo.CitaHistorialRepo;
import com.veterinariasm.citas.repo.CitaRepo;
import com.veterinariasm.citas.repo.CitaServicioRepo;

@Service 
public class CitaService {

    @Autowired 
    private CitaRepo citaRepo;

    @Autowired 
    private CitaServicioRepo citaServicioRepo;

    @Autowired 
    private CitaHistorialRepo citaHistorialRepo;


    //Creacion De una Cita a traves de una CitaServicio
    public CitaServicio crearCitaServicio(ServicioDTO servicioDTO){
        Cita cita = new Cita();
        cita.setFecha(new Date());
        citaRepo.save(cita);

        CitaServicio citaServicio = new CitaServicio(cita.getId(), servicioDTO.getId());
        citaServicioRepo.save(citaServicio);
        return citaServicio;
    }

    //Cambiar fecha establecida por el usuario

    public CitaHistorial guardarHistorial(Cita cita){

        CitaHistorial historial = new CitaHistorial();
        historial.setFecha_registro(new java.sql.Date(System.currentTimeMillis())); 
        historial.setFecha_cita(new java.sql.Date(cita.getFecha().getTime())); 
        historial.setRealizada(false); 

        
        citaHistorialRepo.save(historial);
        return historial;
    }
}
