package com.veterinariasm.cliente_lobby.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

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
    @Schema (description = "telefono (contacto del usuario)")
    private Integer telefono;

    @Column (nullable = false, name = "fecha_ingreso")
    @Temporal(TemporalType.TIMESTAMP) 
    @Schema (description = "fecha de ingreso (para saber en que fecha se ha ingresado el usuario)")
    private Date fechaIngreso;

    @Column (nullable = false,unique = false)
    @Email 
    @Schema (description = "correo (correo del usuario)")
    private String correo;

    @Column (nullable = false,length = 16)
    @Size (min = 8)
    @JsonProperty (access = JsonProperty.Access.WRITE_ONLY)
    @Schema (description = "contrasena (contrasena del usuario)")
    private String contrasena;

    @Column (nullable = false)
    @Schema (description = "estado del usuario (para saber si es un usuario con cuenta activa o inactiva)")
    private Boolean activo;

}
