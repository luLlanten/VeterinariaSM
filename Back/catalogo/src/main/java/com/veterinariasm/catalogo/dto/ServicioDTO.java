package com.veterinariasm.catalogo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class ServicioDTO {
    private Integer id;
    private String categoria;
    private String nombre;
    private Double precio;
}
