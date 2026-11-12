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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Entity 
@Table (name = "user")
@Schema (description = "Se puede elegir si el usuario es veterinario o cliente")
public class User {
    @Id 
    @Column (name = "user_id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Schema (description = "id del usuario, primary key")
    private Integer id;

    @Column (nullable = false,length = 30)
    @NotBlank 
    @Schema (description = "nombre del usuario")
    private String nombre;

    @Column (nullable = false,length = 30)
    @NotBlank 
    @Schema (description = "apellido del usuario")
    private String apellido;

    @Column (nullable = false)
    @Schema (description = "tipo de usuario (si es veterinario o cliente)")
    private Boolean tipo;

    @Column (nullable = false)
    @Schema (description = "estado del usuario (para saber si es un usuario con cuenta activa o inactiva)")
    private Boolean activo;

    @Column (nullable = false,length = 100)
    @Schema (description = "direccion del usuario")
    private String direccion;

    @Column (nullable = false,length = 8)
    @Min (value = 00000001)
    @Max (value = 99999999)
    @Schema (description = "telefono del usuario")
    private Integer telefono;

    @Temporal(TemporalType.TIMESTAMP)
    @Column (nullable = false, name = "fecha_ingreso")
    @Schema (description = "fecha en la que ingreso el usuario")
    private Date fechaIngreso;

    @Column (nullable = false,unique = true)
    @Email 
    @Schema (description = "correo del usuario")
    private String correo;

    @Column (nullable = false,length = 16)
    @Size (min = 8)
    @JsonProperty (access = JsonProperty.Access.WRITE_ONLY) // permite mandar json, pero no recibir por parte del usuario.
    @Schema (description = "contrasena del usuario")
    private String contrasena;
    
}
