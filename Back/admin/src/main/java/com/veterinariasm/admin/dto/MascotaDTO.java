package com.veterinariasm.admin.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class MascotaDTO {
    private Integer id;
    private String nombre;
    private String especie;
    private Double peso;
    private Double tamanio;
    private Date fechaIngreso;
    private Date fechaAlta;
    private Boolean sexo;
    private String raza;
    private Boolean activo;
    private String chip;
    private Integer idUser;
}
