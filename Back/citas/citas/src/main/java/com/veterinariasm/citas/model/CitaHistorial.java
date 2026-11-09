package com.veterinariasm.citas.model;



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
@Table (name = "cita_historial")
public class CitaHistorial {

    @Id 
    @Column (name = "historial_id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (nullable = false)
    private Date fecha_registro;

    @Column (nullable = false)
    private Date fecha_cita;

    @Column (nullable = false)
    private Boolean realizada;

    @Column(name = "id_cita")
    private Cita cita;
}
