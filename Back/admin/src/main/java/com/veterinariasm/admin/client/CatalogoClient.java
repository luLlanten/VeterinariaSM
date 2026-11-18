package com.veterinariasm.admin.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.veterinariasm.admin.dto.MedicamentoDTO;
import com.veterinariasm.admin.dto.ServicioDTO;

@FeignClient (name = "catalogo")
public interface CatalogoClient {
    @GetMapping ("/medicamentos")
    List<MedicamentoDTO> listarMedicamentos();

    @GetMapping ("/servicios")
    List<ServicioDTO> listarServicios();

    @GetMapping ("/medicamentos/{id}")
    MedicamentoDTO getMedicamentoById(@PathVariable Integer id);

    @GetMapping ("/servicios/{id}")
    ServicioDTO getServiciosById(@PathVariable Integer id);

    @PutMapping ("/update/med")
    MedicamentoDTO updateMedicamento(@RequestBody MedicamentoDTO medicamento);

    @PutMapping ("/update/serv")
    ServicioDTO updateServicios(@RequestBody ServicioDTO servicioDTO);

    @PostMapping ("/medicamentos")
    MedicamentoDTO createMedicamento(@RequestBody MedicamentoDTO medCreateDTO);

    @PostMapping ("/servicios")
    ServicioDTO createServicio(@RequestBody ServicioDTO servCreateDTO);

}
