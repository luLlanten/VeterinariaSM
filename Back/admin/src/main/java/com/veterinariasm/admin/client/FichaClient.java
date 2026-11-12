package com.veterinariasm.admin.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.veterinariasm.admin.dto.FichaDTO;
import com.veterinariasm.admin.dto.MascotaDTO;
import com.veterinariasm.admin.dto.NecropsiaDTO;

@FeignClient (name = "ficha")
public interface FichaClient {
    @GetMapping("/mascota/user/{id}")
    List<MascotaDTO> buscarMascotaPorUser(@PathVariable Integer id);

    @GetMapping("/user/{id}")
    List<FichaDTO>buscarFichaPorIdUser(@PathVariable Integer id);

    @GetMapping("/necropsia/mascota/{id}")
    NecropsiaDTO buscarNecropsiaPorIdMascota(@PathVariable Integer id);

    @GetMapping("/necropsia/user/{id}")
    List<NecropsiaDTO>buscarNecropsiaPorIdUsuario(@PathVariable Integer id);

    @GetMapping ("/{id}")
    FichaDTO getFichaById(@PathVariable Integer id);

    @GetMapping
    List<FichaDTO>getAllFicha();

    @GetMapping ("/mascota/{id}")
    MascotaDTO getMascotaPorId(@PathVariable Integer id);

    @GetMapping ("/mascota")
    List<MascotaDTO>getAllMascota();

    @GetMapping("/necropsia/{id}")
    NecropsiaDTO getNecropsiaPorId(@PathVariable Integer id);

    @GetMapping ("/necropsia")
    List<NecropsiaDTO> getAllNecropsia();
}
