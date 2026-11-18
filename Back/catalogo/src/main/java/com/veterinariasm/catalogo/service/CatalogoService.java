package com.veterinariasm.catalogo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinariasm.catalogo.dto.MedicamentoDTO;
import com.veterinariasm.catalogo.dto.ServicioDTO;
import com.veterinariasm.catalogo.model.Medicamento;
import com.veterinariasm.catalogo.model.Servicios;
import com.veterinariasm.catalogo.repo.MedRepo;
import com.veterinariasm.catalogo.repo.ServRepo;

@Service 
public class CatalogoService {
    @Autowired 
    private MedRepo medRepo;

    @Autowired 
    private ServRepo servRepo;

    //catalogo completo
    public List<Medicamento> listarMedicamentos(){
        return medRepo.findAll();
    }
    public List<Servicios>listarServicios(){
        return servRepo.findAll();
    }

    //seleccionar por producto (dirigido a cada card del front supongo)
    //tambien util para admin (get)
    public Medicamento getMedicamentoById(Integer id){
        return medRepo.findById(id).get();
    }
    public Servicios getServiciosById(Integer id){
        return servRepo.findById(id).get();
    }

    //esto se aplica por cada medicamento comprado
    public Medicamento stockMedicamento(Integer id){
        Medicamento medicamento=medRepo.findById(id).get();
        if (!medicamento.equals(null)){
            medicamento.setCantidad(medicamento.getCantidad()-1);
            return medRepo.save(medicamento);
        }
        else{
            return medicamento;
        }
    }

    //procedimientos para admin
    //sets
    public Medicamento updateMedicamento(MedicamentoDTO medicamento){
        Medicamento medicamento2 = medRepo.findById(medicamento.getId()).get();
        if(!medicamento2.equals(null)){
            medicamento2.setNombre(medicamento.getNombre());
            medicamento2.setCantidad(medicamento.getCantidad());
            medicamento2.setPrecio(medicamento.getPrecio());
            medicamento2.setCategoria(medicamento.getCategoria());
            return medRepo.save(medicamento2);
        }else{
            return medicamento2;
        }
    }
    public Servicios updateServicios(ServicioDTO servicioDTO){
        Servicios servicio=servRepo.findById(servicioDTO.getId()).get();
        if(!servicio.equals(null)){
            servicio.setCategoria(servicioDTO.getCategoria());
            servicio.setNombre(servicioDTO.getNombre());
            servicio.setPrecio(servicioDTO.getPrecio());
            return servRepo.save(servicio);
        }else{
            return servicio;
        }
    }
    //adds
    public Medicamento createMedicamento(MedicamentoDTO medCreateDTO){
        Medicamento medicamento=new Medicamento();
        medicamento.setCantidad(medCreateDTO.getCantidad());
        medicamento.setCategoria(medCreateDTO.getCategoria());
        medicamento.setNombre(medCreateDTO.getNombre());
        medicamento.setPrecio(medCreateDTO.getPrecio());
        medicamento.setImagen(medCreateDTO.getImagen());
        return medRepo.save(medicamento);
    }
    public Servicios createServicio(ServicioDTO servCreateDTO){
        Servicios servicio=new Servicios();
        servicio.setCategoria(servCreateDTO.getCategoria());
        servicio.setNombre(servCreateDTO.getNombre());
        servicio.setPrecio(servCreateDTO.getPrecio());
        servicio.setImagen(servCreateDTO.getImagen());
        return servRepo.save(servicio);
    }



}
