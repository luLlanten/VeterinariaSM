package com.veterinariasm.citas.model;

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
public class CitaServicio {

    @Column (name = "servicio_id")
    private Integer servicio_id;

    @Column (name = "citas_id")
    private Integer citas_id;

}
