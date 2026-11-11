package com.veterinariasm.citas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import com.veterinariasm.citas.client.ServicioClient;
import com.veterinariasm.citas.client.UsuarioClient;
import com.veterinariasm.citas.dto.ServicioDTO;
import com.veterinariasm.citas.dto.ServicioRegistroDTO;
import com.veterinariasm.citas.dto.UsuarioDTO;
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
    private UsuarioClient usuarioClient;

    @Autowired
    private ServicioClient servicioClient;


//=====================================================================================================
    public Cita crearCitaServicio(ServicioRegistroDTO servicioDTO){
        Cita cita = new Cita();
        cita.setVigencia(true);

        CitaServicio citaServicio = new CitaServicio(servicioDTO.getServicio().getId(), cita.getId());
        citaServicioRepo.save(citaServicio);
        cita.setFecha(servicioDTO.getFecha());
        return citaRepo.save(cita);
    }

    public ServicioRegistroDTO linkear(Integer idUser, Integer idServicio){
        UsuarioDTO user = usuarioClient.findUsuarioDTOById(idUser);
        ServicioDTO servicio = servicioClient.findServicioDTOById(idServicio);

        ServicioRegistroDTO servicioRegistro = new ServicioRegistroDTO();
        servicioRegistro.setServicio(servicio);
        servicioRegistro.setUsuario(user);
        return servicioRegistro;
    }

    public ServicioRegistroDTO registrarFecha(Date fecha,ServicioRegistroDTO servicioRegistroDTO){
        servicioRegistroDTO.setFecha(fecha);
        return servicioRegistroDTO;
    }
//=====================================================================================================

    public CitaHistorial guardarHistorial(Cita cita){
        CitaHistorial historial = new CitaHistorial();
        historial.setFecha_registro(new Date()); 
        historial.setFecha_cita(cita.getFecha()); 
        historial.setRealizada(false); 
        
        citaHistorialRepo.save(historial);
        return historial;
    }

    public CitaHistorial buscarHistorialPorId(Integer id){
        return citaHistorialRepo.findById(id).get();
    }

    public Cita buscarCitaPorId(Integer id){
        return citaRepo.findById(id).get();
    }

    public  List<Cita> buscarCitasPorUsuario(Integer id){
        return citaRepo.findByIdUsuario(id);
    }

    public CitaHistorial buscarHistorialPorUsuario(Cita cita){
        return citaHistorialRepo.findByCita(cita);
    }

    public void modificarCita(Cita cita){
        Cita citaViejo = citaRepo.findById(cita.getId()).get();
        citaViejo.setFecha(cita.getFecha());
        citaRepo.save(citaViejo);
    }

    public void eliminarCita(Integer id){
        Cita cita = citaRepo.findById(id).get();
        cita.setVigencia(false);
        citaRepo.save(cita);
    }
}