package com.veterinariasm.ficha.model;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema (description = "Necropsia se encargara de ingresar las causas de muerte de una mascota")
public class Necropsia {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Schema (description = "id de la necropsia")
    private Integer id;

    @Column (nullable = false)
    @Schema (description = "fecha en la que se hizo la necropsia")
    private Date fecha;

    @Column (nullable = false, length = 10000)
    @Schema (description = "condicion corporal de la mascota que se pueden ver visualmente")
    private String condicion_corporal_visual;

    @Column (nullable = false, length = 10000)
    @Schema (description = "grado de descomposicion de la mascota")
    private String grado_de_descomposicion;

    @Column (nullable = false, length = 5000)
    @Schema (description = "antecedentes de la mascota")
    private String antecedentes;

    @Column (nullable = false, length = 5000)
    @Schema (description = "examen interno de la mascota")
    private String examen;

    @Column (nullable = false, length = 5000)
    @Schema (description = "muestras remitidas de la mascota")
    private String muestra_remitidas;


    @Column (name = "usuario_id")
    @Schema (description = "id del usuario")
    private Integer idUsuario;

    @Column (name = "mascota_id", unique = true)
    @Schema (description = "id de la mascota")
    private Integer idMascota;

}
