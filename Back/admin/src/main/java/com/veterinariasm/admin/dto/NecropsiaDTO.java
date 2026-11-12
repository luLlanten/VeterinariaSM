package com.veterinariasm.admin.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class NecropsiaDTO {
    private Integer id;
    private Date fecha;
    private String condCorporal;
    private String gradoDesc;
    private String antecedentes;
    private String examenInt;
    private String examenExt;
    private String muestrasRemitidas;
    private Integer idUser;
    private Integer idMascota;
}
