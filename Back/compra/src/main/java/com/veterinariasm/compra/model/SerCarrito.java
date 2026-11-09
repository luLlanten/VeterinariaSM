package com.veterinariasm.compra.model;

import com.veterinariasm.compra.dto.ServicioDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
@Entity 
@Table (name = "ser_carrito")
public class SerCarrito {
    @Column (name = "servicio_id")
    private ServicioDTO servicioDTO;

    @Column (name="carrito_id")
    private Carrito carrito;
}
