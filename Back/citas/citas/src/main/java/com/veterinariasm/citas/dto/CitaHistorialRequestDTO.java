package com.veterinariasm.citas.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class CitaHistorialRequestDTO {

    private Date fecha_registro;
    private Date fecha_cita;
    private Boolean realizada;
    
}
