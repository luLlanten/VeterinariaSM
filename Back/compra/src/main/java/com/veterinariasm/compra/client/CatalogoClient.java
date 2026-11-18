package com.veterinariasm.compra.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.veterinariasm.compra.dto.MedicamentoDTO;
import com.veterinariasm.compra.dto.ServicioDTO;

@FeignClient (name = "catalogo")
public interface CatalogoClient { 
    @GetMapping ("/medicamentos/{id}")
    MedicamentoDTO getMedicamentoById(@PathVariable Integer id);

    @GetMapping ("/servicios/{id}")
    ServicioDTO getServiciosById(@PathVariable Integer id);

    @PatchMapping ("/med-stock/{id}")
    public ResponseEntity<Void> stockMedicamento(@PathVariable Integer id);
}
