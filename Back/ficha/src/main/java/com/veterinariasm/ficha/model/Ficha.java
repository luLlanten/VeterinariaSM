package com.veterinariasm.ficha.model;

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
@AllArgsConstructor 
@NoArgsConstructor 
@Entity 
@Table (name = "ficha")
public class Ficha {

    @Id 
    @Column (name = "ficha_id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (nullable = false)
    private Date fecha_ficha;

    @Column (nullable = false, length = 5000)
    private String antecedentes;

    @Column (name = "usuario_id")
    private Integer idUsuario;

    @Column (name = "mascota_id")
    private Integer idMascota;

}
