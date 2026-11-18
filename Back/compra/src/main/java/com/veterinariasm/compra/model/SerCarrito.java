package com.veterinariasm.compra.model;

import com.veterinariasm.compra.dto.ServicioDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
@Entity 
@Table (name = "ser_carrito")
@Schema (description = "servicio que se solicito")
public class SerCarrito {
    @EmbeddedId 
    @ManyToOne 
    @JoinColumn (name="carrito_id")
    @Schema (description = "id del carrito")
    private Carrito carrito;

    @Column (name = "servicio_id")
    @Schema (description = "id del servicio")
    private ServicioDTO servicioDTO;
}
