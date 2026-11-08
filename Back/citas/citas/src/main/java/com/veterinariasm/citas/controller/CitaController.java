package com.veterinariasm.citas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veterinariasm.citas.dto.ServicioDTO;
import com.veterinariasm.citas.model.Cita;
import com.veterinariasm.citas.model.CitaHistorial;
import com.veterinariasm.citas.model.CitaServicio;
import com.veterinariasm.citas.service.CitaService;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @PostMapping("/crear")
    public ResponseEntity<CitaServicio> crearCita(@RequestBody ServicioDTO servicioDTO) {
        CitaServicio nuevaCitaServicio = citaService.crearCitaServicio(servicioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCitaServicio);
    }

    @PostMapping("/historial")
    public ResponseEntity<CitaHistorial> guardarHistorial(@RequestBody Cita cita) {
        CitaHistorial nuevoHistorial = citaService.guardarHistorial(cita);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoHistorial);
    }
}