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
@Table (name = "ficha")
@Schema (description = "Ficha se encargara de tener los antecedentes de la mascota y el id de mascota y usuario")
public class Ficha {

    @Id 
    @Column (name = "ficha_id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Schema (description = "id de la ficha")
    private Integer id;

    @Column (nullable = false)
    @Schema (description = "fecha en la que se hizo la ficha")
    private Date fecha_ficha;

    @Column (nullable = false, length = 5000)
    @Schema (description = "antecedentes donde se ingresara los datos de la mascota")
    private String antecedentes;

    @Column (name = "usuario_id")
    @Schema (description = "id del usuario")
    private Integer idUsuario;

    @Column (name = "mascota_id")
    @Schema (description = "id de la mascota")
    private Integer idMascota;

}
