package com.veterinariasm.citas.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
@Entity 
@Table (name = "cita_servicio")
@Schema (description = "cita servicio se encarga de mostrar el servicio que se pido y los datos de la cita")
public class CitaServicio {

    @Column (name = "servicio_id")
    @Schema (description = "id del servicio")
    private Integer servicio_id;

    @Column (name = "citas_id")
    @Schema (description = "id de la cita")
    private Integer citas_id;
    
}
