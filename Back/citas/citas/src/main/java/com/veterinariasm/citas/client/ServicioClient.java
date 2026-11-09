package com.veterinariasm.citas.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.veterinariasm.citas.dto.ServicioDTO;

@FeignClient (name = "catalogo")
public interface ServicioClient {

    @GetMapping ("/servicio/{id}")
    ServicioDTO findServicioDTOById(@PathVariable Integer id);

}
