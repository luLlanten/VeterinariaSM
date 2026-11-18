package com.veterinariasm.compra.dto;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
@Embeddable
public class ServicioDTO {
    private Integer id;
    private Double precio;
}
