package com.veterinariasm.admin.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class CitaHistorialDTO {
    private Integer id;
    private Date fecha_registro;
    private Date fecha_cita;
    private Boolean realizada;
    private CitaDTO cita;
}
