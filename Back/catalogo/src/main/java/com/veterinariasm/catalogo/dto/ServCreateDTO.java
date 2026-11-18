package com.veterinariasm.catalogo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class ServCreateDTO {
    private String categoria;
    private String nombre;
    private Double precio;
}
