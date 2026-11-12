package com.veterinariasm.admin.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class UserDTO {
    private Integer id;
    private String nombre;
    private String apellido;
    private Boolean tipo;
    private Boolean activo;
    private String direccion;
    private Integer telefono;
    private Date fechaIngreso;
    private String correo;
    private String contrasena; 
}
