package com.veterinariasm.compra.model;

import com.veterinariasm.compra.dto.MedicamentoDTO;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema (description = "llamara al id de medicamento y de carrito")
public class MedCarrito {
    @Column (name = "medicamento_id")
    @Schema (description = "id del medicamento")
    private MedicamentoDTO medicamentoDTO;

    @Column(name="carrito_id")
    @Schema (description = "id del carrito")
    private Carrito carrito;
}
