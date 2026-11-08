package com.veterinariasm.cliente_lobby.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class AdminDTO {

    private String correo;
    private String contrasena;
}
