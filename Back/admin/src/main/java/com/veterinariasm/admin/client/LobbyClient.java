package com.veterinariasm.admin.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.veterinariasm.admin.dto.AdminDTO;
import com.veterinariasm.admin.dto.UserDTO;

@FeignClient (name = "cliente-lobby")
public interface LobbyClient {
    @GetMapping ("/admin/{id}")
    AdminDTO findAdminById(@PathVariable Integer id);

    @GetMapping ("/user/{id}")
    UserDTO findUserById(@PathVariable Integer id);

    @GetMapping ("/users")
    List<UserDTO>listUsers();

    @GetMapping ("/admins")
    List<AdminDTO>listAdmins();
}
