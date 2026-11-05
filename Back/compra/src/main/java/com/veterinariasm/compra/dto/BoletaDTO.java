package com.veterinariasm.compra.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class BoletaDTO {
    private Date fecha;
    private Integer total;
}
