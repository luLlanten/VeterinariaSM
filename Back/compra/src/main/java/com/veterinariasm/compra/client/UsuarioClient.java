package com.veterinariasm.compra.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.veterinariasm.compra.dto.UsuarioDTO;

@FeignClient (name = "cliente-lobby")
public interface UsuarioClient {
    @GetMapping ("/{id}")
    UsuarioDTO finUsuarioDTO(@PathVariable Integer id);
}
