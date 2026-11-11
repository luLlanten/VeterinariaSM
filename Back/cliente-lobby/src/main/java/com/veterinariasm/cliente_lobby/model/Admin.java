package com.veterinariasm.cliente_lobby.model;

import java.util.Date;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Entity 
@Table (name = "admin")
@Schema (description = "Usuario de admin, tiene datos y caracteristicas diferentes a un usuario normal")
public class Admin {
    @Id 
    @Column (name = "admin_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema (description = "id del usuario admin, primary key") 
    private Integer id;

    @Column (nullable = false, length = 30)
    @Pattern (regexp = "^[A-Za-z]$")
    @NotBlank
    @Schema(description = "nombre de usuario")
    private String nombre;
    
    @Column (nullable = false,length = 30)
    @NotBlank
    @Pattern (regexp = "^[A-Za-z]$")
    @Schema (description = "apellido del usuario") 
    private String apellido;

    @Column (nullable = false,length = 8)
    @Pattern (regexp = "^[0-9]$")
    @Schema (description = "telefono (contacto del usuario)")
    private Integer telefono;

    @Column (nullable = false, name = "fecha_ingreso")
    @Temporal(TemporalType.TIMESTAMP) 
    private Date fechaIngreso;

    @Column (nullable = false,unique = false)
    @Email 
    private String correo;

    @Column (nullable = false,length = 16)
    @Size (min = 8)
    private String contrasena;

    @Column (nullable = false)
    private Boolean activo;

}
