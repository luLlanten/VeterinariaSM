package com.veterinariasm.ficha.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data 
@AllArgsConstructor
@NoArgsConstructor 
public class MascotaDTO {

    private String nombre;
    private String especie;
    private Double peso;
    private Double tamaño;
    private Date fecha_ingreso;
    private Date fecha_alta;
    private Boolean sexo;
    private String raza;
    private Boolean activo;
    private String chip;

}
