package com.veterinariasm.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class CarritoDTO {
    private Integer id;
    private Integer cantidad;
    private Double total;
    private Integer usuarioId;
}
