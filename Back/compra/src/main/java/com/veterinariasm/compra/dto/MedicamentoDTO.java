package com.veterinariasm.compra.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class MedicamentoDTO {
    private Integer id;
    private Double precio;
}
