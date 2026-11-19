package com.veterinariasm.admin.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.veterinariasm.admin.dto.UserDTO;

@FeignClient (name = "cliente-lobby")
public interface LobbyClient {
    @PatchMapping ("/user/veterinario/{id}")
    UserDTO setVeterinario(@PathVariable Integer id);
}
