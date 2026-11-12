package com.veterinariasm.ficha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class FichaCompletaDTO {

    private FichaDTO ficha;
    private MascotaDTO mascota;

}
