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

import io.swagger.v3.oas.annotations.media.Schema;

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

    @Schema (description = "metodo que crea la cita y obtiene el tipo de servicio")
    public Cita crearCitaServicio(ServicioRegistroDTO servicioDTO){
        Cita cita = new Cita();
        cita.setVigencia(true);

        CitaServicio citaServicio = new CitaServicio(servicioDTO.getServicio().getId(), cita.getId());
        citaServicioRepo.save(citaServicio);
        cita.setFecha(servicioDTO.getFecha());
        return citaRepo.save(cita);
    }

    @Schema (description = "metodo que conecta el usuario con el servicio")
    public ServicioRegistroDTO linkear(Integer idUser, Integer idServicio){
        UsuarioDTO user = usuarioClient.findUsuarioDTOById(idUser);
        ServicioDTO servicio = servicioClient.findServicioDTOById(idServicio);

        ServicioRegistroDTO servicioRegistro = new ServicioRegistroDTO();
        servicioRegistro.setServicio(servicio);
        servicioRegistro.setUsuario(user);
        return servicioRegistro;
    }

    @Schema (description = "metodo que registra la fecha")
    public ServicioRegistroDTO registrarFecha(Date fecha,ServicioRegistroDTO servicioRegistroDTO){
        servicioRegistroDTO.setFecha(fecha);
        return servicioRegistroDTO;
    }
//=====================================================================================================

    @Schema (description = "metodo para guardar el historial")
    public CitaHistorial guardarHistorial(Cita cita){
        CitaHistorial historial = new CitaHistorial();
        historial.setFecha_registro(new Date()); 
        historial.setFecha_cita(cita.getFecha()); 
        historial.setRealizada(false); 
        
        citaHistorialRepo.save(historial);
        return historial;
    }

    @Schema (description = "metodo para buscar el historial por id")
    public CitaHistorial buscarHistorialPorId(Integer id){
        return citaHistorialRepo.findById(id).get();
    }

    @Schema (description = "metodo para buscar cita por id")
    public Cita buscarCitaPorId(Integer id){
        return citaRepo.findById(id).get();
    }

    @Schema (description = "metodo para buscar cita por usuario")
    public  List<Cita> buscarCitasPorUsuario(Integer id){
        return citaRepo.findByIdUsuario(id);
    }

    @Schema (description = "metodo para buscar historial por usuario")
    public CitaHistorial buscarHistorialPorUsuario(Cita cita){
        return citaHistorialRepo.findByCita(cita);
    }

    @Schema (description = "metodo para modificar la cita")
    public void modificarCita(Cita cita){
        Cita citaViejo = citaRepo.findById(cita.getId()).get();
        citaViejo.setFecha(cita.getFecha());
        citaRepo.save(citaViejo);
    }

    @Schema (description = "metodo para eliminar cita")
    public void eliminarCita(Integer id){
        Cita cita = citaRepo.findById(id).get();
        cita.setVigencia(false);
        citaRepo.save(cita);
    }
}