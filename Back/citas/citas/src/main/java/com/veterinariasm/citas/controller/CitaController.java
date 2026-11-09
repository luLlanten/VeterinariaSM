package com.veterinariasm.citas.controller;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veterinariasm.citas.dto.ServicioDTO;
import com.veterinariasm.citas.model.Cita;
import com.veterinariasm.citas.model.CitaHistorial;
import com.veterinariasm.citas.model.CitaServicio;
import com.veterinariasm.citas.service.CitaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @PostMapping("/crear/{idUser}/{idServicio}")
    public ResponseEntity<Cita> crearCita(@PathVariable Integer idUser, @PathVariable Integer idServicio,@RequestBody Date fecha) {
        Cita cita = citaService.crearCitaServicio(citaService.registrarFecha(fecha, citaService.linkear(idUser, idServicio)));
        return ResponseEntity.ok(cita);
    }

    @PostMapping("/historial")
    public ResponseEntity<CitaHistorial> guardarHistorial(@RequestBody Cita cita) {
        CitaHistorial nuevoHistorial = citaService.guardarHistorial(cita);
        return ResponseEntity.ok(nuevoHistorial);
    }

    @GetMapping("/historial/{id}")
    public ResponseEntity<CitaHistorial> buscarHistorialPorId(@PathVariable Integer id) {
        CitaHistorial buscar = citaService.buscarHistorialPorId(id);
        return ResponseEntity.ok(buscar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cita> buscarCitaPorId(@PathVariable Integer id) {
        Cita buscar = citaService.buscarCitaPorId(id);
        return ResponseEntity.ok(buscar);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Cita>> buscarCitasPorUsuario(@PathVariable Integer id) {
        List<Cita> buscar = citaService.buscarCitasPorUsuario(id);
        return ResponseEntity.ok(buscar);
    }

    @GetMapping("/user/historial")
    public ResponseEntity<CitaHistorial> buscarHistorialPorUsuario(@RequestBody Cita cita) {
        CitaHistorial buscar = citaService.buscarHistorialPorUsuario(cita);
        return ResponseEntity.ok(buscar);
    }

    @PutMapping("/modificar")
    public ResponseEntity<Void> modificarCita(@RequestBody Cita cita) {
        citaService.modificarCita(cita);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarCita(@PathVariable Integer id){
        citaService.eliminarCita(id);
        return ResponseEntity.noContent().build();
    } 
    
    

}