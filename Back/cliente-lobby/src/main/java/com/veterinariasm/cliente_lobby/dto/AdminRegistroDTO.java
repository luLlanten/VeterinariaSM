package com.veterinariasm.cliente_lobby.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class AdminRegistroDTO {
    private String nombre;
    private String apellido;
    private Integer telefono;
    private String correo;
    private String contrasena;
}
