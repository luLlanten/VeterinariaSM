package com.veterinariasm.citas.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.veterinariasm.citas.dto.UsuarioDTO;

@FeignClient (name = "cliente-lobby")
public interface UsuarioClient {

    @GetMapping ("/user/{id}")
    UsuarioDTO findUsuarioDTOById(@PathVariable Integer id);
    

}
