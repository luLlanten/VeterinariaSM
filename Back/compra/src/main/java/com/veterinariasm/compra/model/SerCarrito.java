package com.veterinariasm.compra.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class SerCarrito {
    @Column (name = "servicio_id")
    private Integer serId;

    @Column (name="carrito_id")
    private Integer carritoId;
}
