package com.veterinariasm.citas.model;

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
@Table (name = "cita")
@Schema (description = "Cita contiene su propio id y se encargara de asignar la fecha de la cita y si sigue vigente o no")
public class Cita {

    @Id
    @Column (name = "cita_id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Schema (description = "id de la cita")
    private Integer id;

    @Column (nullable = false)
    @Schema (description = "fecha de la cita")
    private Date fecha;

    @Column (name = "usuario_id")
    @Schema (description = "id del usuario")
    private Integer idUsuario;

    @Column (nullable = false)
    @Schema (description = "vigencia de la cita")
    private Boolean vigencia;
}
