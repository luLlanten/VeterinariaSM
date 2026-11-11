package com.veterinariasm.citas.controller;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veterinariasm.citas.dto.ServicioRegistroDTO;
import com.veterinariasm.citas.model.Cita;
import com.veterinariasm.citas.model.CitaHistorial;
import com.veterinariasm.citas.service.CitaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @PostMapping("/crear/{idUser}/{idServicio}")
    public ResponseEntity<Cita> crearCita(@PathVariable Integer idUser, @PathVariable Integer idServicio,@RequestBody Date fecha) {
        try{
            ServicioRegistroDTO serv=citaService.linkear(idUser, idServicio);
            if(!serv.equals(null)){
                serv=citaService.registrarFecha(fecha,serv);
                Cita cita = citaService.crearCitaServicio(serv);
                return ResponseEntity.ok(cita);
            }else{
                return ResponseEntity.notFound().build();
            }
        }
        catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/historial")
    public ResponseEntity<CitaHistorial> guardarHistorial(@RequestBody Cita cita) {
        try {
            CitaHistorial nuevoHistorial = citaService.guardarHistorial(cita);
            return ResponseEntity.ok(nuevoHistorial);    
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        
    }

    @GetMapping("/historial/{id}")
    public ResponseEntity<CitaHistorial> buscarHistorialPorId(@PathVariable Integer id) {
        try{
            CitaHistorial buscar = citaService.buscarHistorialPorId(id);
            if(!buscar.equals(null))
                {return ResponseEntity.ok(buscar);}
            else{
                return ResponseEntity.notFound().build();
            }
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cita> buscarCitaPorId(@PathVariable Integer id) {
        try{
            Cita buscar = citaService.buscarCitaPorId(id);
            if(!buscar.equals(null)){
                return ResponseEntity.ok(buscar);
            }else{
                return ResponseEntity.notFound().build();
            }
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Cita>> buscarCitasPorUsuario(@PathVariable Integer id) {
        try{
            List<Cita> buscar = citaService.buscarCitasPorUsuario(id);
            return ResponseEntity.ok(buscar);
        }catch(Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/user/historial")
    public ResponseEntity<CitaHistorial> buscarHistorialPorUsuario(@RequestBody Cita cita) {
        try{
            CitaHistorial buscar = citaService.buscarHistorialPorUsuario(cita);
            if(!buscar.equals(null)){
                return ResponseEntity.ok(buscar);
            }else{
                return ResponseEntity.notFound().build();
            }
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/modificar")
    public ResponseEntity<Void> modificarCita(@RequestBody Cita cita) {
        try{
            citaService.modificarCita(cita);
            return ResponseEntity.accepted().build();
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarCita(@PathVariable Integer id){
        try{
            citaService.eliminarCita(id);
            return ResponseEntity.noContent().build();
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    } 
    
    

}