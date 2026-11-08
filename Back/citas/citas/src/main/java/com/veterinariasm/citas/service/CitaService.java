package com.veterinariasm.citas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import com.veterinariasm.citas.client.CitaClient;
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

    @Autowired
    private CitaClient citaClient;

    public CitaServicio crearCitaServicio(ServicioDTO servicioDTO){
        Cita cita = new Cita();
        cita.setFecha(new java.util.Date());
        citaRepo.save(cita);

        CitaServicio citaServicio = new CitaServicio(servicioDTO.getId(), cita.getId());
        citaServicioRepo.save(citaServicio);
        return citaServicio;
    }

    public CitaHistorial guardarHistorial(Cita cita){
        CitaHistorial historial = new CitaHistorial();
        historial.setFecha_registro(new java.sql.Date(System.currentTimeMillis())); 
        historial.setFecha_cita(new java.sql.Date(cita.getFecha().getTime())); 
        historial.setRealizada(false); 
        
        citaHistorialRepo.save(historial);
        return historial;
    }

    public ServicioDTO obtenerServicioPorCita(Integer citaId) {
        Optional<CitaServicio> relacion = citaServicioRepo.findById(citaId);
        if (relacion.isPresent()) {
            return citaClient.obtenerServicioPorId(relacion.get().getServicio_id());
        }
        return null;
    }
}