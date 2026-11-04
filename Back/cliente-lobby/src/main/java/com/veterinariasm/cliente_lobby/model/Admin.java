package com.veterinariasm.cliente_lobby.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Entity 
@Table (name = "admin")
public class Admin {
    @Id 
    @Column (name = "admin_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @Column (nullable = false, length = 30)
    private String nombre;
    
    @Column (nullable = false,length = 30)
    private String apellido;

    @Column (nullable = false,length = 8)
    private Integer telefono;

    @Column (nullable = false)
    private Date fechaIngreso;

    @Column (nullable = false)
    private String correo;

    @Column (nullable = false,length = 16)
    private String contrasena;

}
