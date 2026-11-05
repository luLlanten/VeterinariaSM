package com.veterinariasm.citas.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class CitaResponseDTO {

    private Integer id;
    private Date fecha;
    
}
