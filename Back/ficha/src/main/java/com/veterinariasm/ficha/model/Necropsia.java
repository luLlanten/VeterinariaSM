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
@Table (name = "necropsia")
public class Necropsia {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (nullable = false)
    private Date fecha;

    @Column (nullable = false, length = 10000)
    private String condicion_corporal;

    @Column (nullable = false, length = 10000)
    private String grado_de_descomposicion;

    @Column (nullable = false, length = 5000)
    private String antecedentes;

    @Column (nullable = false, length = 5000)
    private String examen_interno;

    @Column (nullable = false, length = 5000)
    private String examen_externo;

    @Column (nullable = false, length = 5000)
    private String muestra_remitidas;


    @Column (name = "usuario_id")
    private Integer idUsuario;

    @Column (name = "mascota_id")
    private Integer idMascota;

}
