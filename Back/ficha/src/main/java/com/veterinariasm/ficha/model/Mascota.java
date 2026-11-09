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
@Table(name = "mascota")
public class Mascota {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column (nullable = false, length = 20)
    private String nombre;

    @Column (nullable = false, length = 50)
    private String especie;

    @Column 
    private Double peso;

    @Column 
    private Double tamaño;

    @Column (nullable = false)
    private Date fecha_ingreso;

    @Column (nullable = false)
    private Date fecha_alta;

    @Column (nullable = false)
    private Boolean sexo;

    @Column (nullable = false, length = 30)
    private String raza;

    @Column (nullable = false)
    private Boolean activo;

    @Column (nullable = false, length = 10)
    private String chip;

    @Column (name = "usuario_id")
    private Integer idUsuario;
}
