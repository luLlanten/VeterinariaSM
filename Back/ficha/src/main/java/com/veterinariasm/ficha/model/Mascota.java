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
@Table(name = "mascota")
@Schema (description = "mascota es donde estaran las caracteristicas y datos de la mascota")
public class Mascota {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Schema (description = "id de la mascota")
    private Integer id;
    
    @Column (nullable = false, length = 20)
    @Schema (description = "nombre de la mascota")
    private String nombre;

    @Column (nullable = false, length = 50)
    @Schema (description = "especie de la mascota")
    private String especie;

    @Column 
    @Schema (description = "peso de la mascota")
    private Double peso;

    @Column 
    @Schema (description = "tamanio de la mascota")
    private Double tamanio;

    @Column (nullable = false)
    @Schema (description = "fecha en la que se ingreso mascota")
    private Date fecha_ingreso;

    @Column (nullable = false)
    @Schema (description = "fecha en la que se dara alta a la mascota")
    private Date fecha_alta;

    @Column (nullable = false)
    @Schema (description = "sexo de la mascota")
    private Boolean sexo;

    @Column (nullable = false, length = 30)
    @Schema (description = "raza de la mascota")
    private String raza;

    @Column (nullable = false)
    @Schema (description = "estado de la mascota (para saber si es una mascota con estado activo o inactivo)")
    private Boolean activo;

    @Column (nullable = false, length = 10)
    @Schema (description = "chip de la mascota")
    private String chip;

    @Column (name = "usuario_id")
    @Schema (description = "id del usuario para saber a quien le pertenece la mascota")
    private Integer idUsuario;
}
