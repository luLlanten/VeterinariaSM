package com.veterinariasm.cliente_lobby.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistroDTO {
    private String nombre;
    private String apellido;
    private Boolean tipo;
    private String direccion;
    private Integer telefono;
    private String correo;
    private String contrasena;
}
