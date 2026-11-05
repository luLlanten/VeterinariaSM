package com.veterinariasm.compra.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class MedCarrito {
    @Column (name = "medicamento_id")
    private Integer medId;

    @Column(name="carrito_id")
    private Integer carritoId;
}
