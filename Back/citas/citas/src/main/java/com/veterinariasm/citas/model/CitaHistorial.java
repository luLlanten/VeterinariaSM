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
@Table (name = "cita_historial")
@Schema (description = "el historial de cita mostrara las citas que se hicieron anteriormente")
public class CitaHistorial {

    @Id 
    @Column (name = "historial_id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Schema (description = "id del historial de cita")
    private Integer id;

    @Column (nullable = false)
    @Schema (description = "fecha en la que se hizo el registro de la fecha")
    private Date fecha_registro;

    @Column (nullable = false)
    @Schema (description = "fecha en la que se hizo la cita")
    private Date fecha_cita;

    @Column (nullable = false)
    @Schema (description = "estado que muestra si la cita se realizo o no")
    private Boolean realizada;

    @Column(name = "id_cita")
    @Schema (description = "id de la cita")
    private Cita cita;
}
