package com.veterinariasm.admin.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.veterinariasm.admin.dto.CitaDTO;
import com.veterinariasm.admin.dto.CitaHistorialDTO;

@FeignClient (name = "citas")
public interface CitaClient {
    //admin solo puede ver las citas, no puede modificar
    @GetMapping("/{id}")
    CitaDTO buscarCitaPorId(@PathVariable Integer id);

    @GetMapping("/user/{id}")
    List<CitaDTO> buscarCitasPorUsuario(@PathVariable Integer id);

    @GetMapping("/user/historial")
    CitaHistorialDTO buscarHistorialPorUsuario(@RequestBody CitaDTO cita);
}
