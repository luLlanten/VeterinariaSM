package com.veterinariasm.catalogo.model;

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
@Table (name = "medicamento")
public class Medicamento {
    @Id 
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column (nullable = false)
    private String categoria;

    @Column (nullable = false)
    private String nombre;

    @Column (nullable=false)
    @Min (value = 0)
    private Double precio;
}
