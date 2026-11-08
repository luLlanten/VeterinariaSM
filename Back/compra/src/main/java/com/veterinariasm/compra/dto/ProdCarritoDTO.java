package com.veterinariasm.compra.dto;

import com.veterinariasm.compra.model.MedCarrito;
import com.veterinariasm.compra.model.SerCarrito;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor
public class ProdCarritoDTO {
    private SerCarrito servicio;
    private MedCarrito medicamento;
}
