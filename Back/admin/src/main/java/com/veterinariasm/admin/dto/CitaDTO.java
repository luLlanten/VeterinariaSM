package com.veterinariasm.admin.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class CitaDTO {
    private Integer id;
    private Date fecha;
    private Integer idUsuario;
    private Boolean vigencia;
}
