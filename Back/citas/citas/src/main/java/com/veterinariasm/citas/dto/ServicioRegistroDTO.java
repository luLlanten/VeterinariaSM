package com.veterinariasm.citas.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class ServicioRegistroDTO {

    private Date fecha;
    private ServicioDTO servicio;
    private UsuarioDTO usuario;

}
