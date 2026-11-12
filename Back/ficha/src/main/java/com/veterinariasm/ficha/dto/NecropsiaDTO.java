package com.veterinariasm.ficha.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class NecropsiaDTO {

    private Date fecha;
    private String condicion_corporal_visual;
    private String grado_de_descomposicion;
    private String antecedentes;
    private String examen_interno;
    private String muestra_remitidas;

}
