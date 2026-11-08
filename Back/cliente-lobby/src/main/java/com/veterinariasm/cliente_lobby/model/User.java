package com.veterinariasm.cliente_lobby.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
    private String nombre;

    @Column (nullable = false,length = 30)
    private String apellido;

    @Column (nullable = false)
    private Boolean tipo;

    @Column (nullable = false)
    private Boolean activo;

    @Column (nullable = false,length = 100)
    private String direccion;

    @Column (nullable = false,length = 8)
    private Integer telefono;

    @Temporal(TemporalType.TIMESTAMP)
    @Column (nullable = false)
    private Date fechaIngreso;

    @Column (nullable = false,unique = true)
    private String correo;

    @Column (nullable = false,length = 16)
    private String contrasena;
    
    //olvide poner las contraseñas y los correos 
}
