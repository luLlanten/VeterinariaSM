package com.veterinariasm.cliente_lobby.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class User {
    @Id 
    @Column (name = "user_id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (nullable = false,length = 30)
    @NotBlank 
    private String nombre;

    @Column (nullable = false,length = 30)
    @NotBlank 
    private String apellido;

    @Column (nullable = false)
    private Boolean tipo;

    @Column (nullable = false)
    private Boolean activo;

    @Column (nullable = false,length = 100)
    private String direccion;

    @Column (nullable = false,length = 8)
    @Min (value = 00000001)
    @Max (value = 99999999)
    private Integer telefono;

    @Temporal(TemporalType.TIMESTAMP)
    @Column (nullable = false, name = "fecha_ingreso")
    private Date fechaIngreso;

    @Column (nullable = false,unique = true)
    @Email 
    private String correo;

    @Column (nullable = false,length = 16)
    @Size (min = 8)
    @JsonProperty (access = JsonProperty.Access.WRITE_ONLY) // permite mandar json, pero no recibir por parte del usuario.
    private String contrasena;
    
    //olvide poner las contraseñas y los correos 
}
