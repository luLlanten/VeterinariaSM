package com.veterinariasm.compra.model;

import com.veterinariasm.compra.dto.MedicamentoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Entity 
@Table (name = "med_carrito")
public class MedCarrito {
    @Column (name = "medicamento_id")
    private MedicamentoDTO medicamentoDTO;

    @Column(name="carrito_id")
    private Carrito carrito;
}
