package com.veterinariasm.admin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
@Entity 
@Table (name = "log")
public class Log {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "log_id")
    private Integer id;

    @Column (nullable = false,length=1000)
    private String mensaje;

    @Column (nullable= false, length = 100)
    private String ruta;

    @Column (name = "admin_id")
    private Integer adminId;
}
