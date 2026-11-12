package com.veterinariasm.compra.model;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor
@Entity  
@Table (name = "boleta")
@Schema (description = "Guarda los datos de compra del carrito, incluyendo la fecha")
public class Boleta {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Schema (description = "id de la boleta")
    private Integer id;

    @Column (nullable = false)
    @Schema (description = "fecha de la boleta")
    private Date fecha;

    @Column (name = "id_carrito")
    @Schema (description = "id del carrito")
    private Carrito carrito;
}
