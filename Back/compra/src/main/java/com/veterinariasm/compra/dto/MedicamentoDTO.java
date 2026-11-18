package com.veterinariasm.compra.dto;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Embeddable 
public class MedicamentoDTO {
    private Integer id;
    private Double precio;
}
