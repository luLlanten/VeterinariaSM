package com.veterinariasm.compra.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
@Entity 
@Table (name = "carrito")
@Schema (description = "carrito para almacenar el total de productos")
public class Carrito {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Schema (description = "id del carrito")
    private Integer id;

    @Column(nullable = false)
    @Min (value = 1) 
    @Schema (description = "cantidad de productos que se almacenaran en el carro")
    private Integer cantidad;

    @Column 
    @Min (value = 0)
    @Schema (description = "precio total")
    private Double total;

    @Column (name= "usuario_id")
    @Schema (description = "id del usuario")
    private Integer usuarioId;
}
