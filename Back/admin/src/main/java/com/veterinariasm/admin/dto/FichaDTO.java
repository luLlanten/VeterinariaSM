package com.veterinariasm.admin.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class FichaDTO {
    private Integer id;
    private Date fechaFicha;
    private String antecedentes;
    private Integer idUser;
    private Integer idMascota;
}
