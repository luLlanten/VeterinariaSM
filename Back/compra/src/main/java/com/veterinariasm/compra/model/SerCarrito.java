package com.veterinariasm.compra.model;

import com.veterinariasm.compra.dto.ServicioDTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class SerCarrito {
    @Column (name = "servicio_id")
    private ServicioDTO servicioDTO;

    @Column (name="carrito_id")
    private Carrito carrito;
}
