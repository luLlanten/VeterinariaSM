package com.veterinariasm.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class ServicioDTO {
    private Integer id;
    private String categoria;
    private String nombre;
    private Double precio;
}
