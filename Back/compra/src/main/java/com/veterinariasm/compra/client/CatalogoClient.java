package com.veterinariasm.compra.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.veterinariasm.compra.dto.MedicamentoDTO;
import com.veterinariasm.compra.dto.ServicioDTO;

@FeignClient (name = "catalogo")
public interface CatalogoClient { 
    @GetMapping ("/medicamento/{id}")
    MedicamentoDTO findMedicamentoDTO(@PathVariable Integer id);

    @GetMapping ("/servicio/{id}")
    ServicioDTO findServicioDTO(@PathVariable Integer id);
}
