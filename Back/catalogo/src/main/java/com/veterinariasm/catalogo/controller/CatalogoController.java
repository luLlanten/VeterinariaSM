package com.veterinariasm.catalogo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.veterinariasm.catalogo.dto.MedicamentoDTO;
import com.veterinariasm.catalogo.dto.ServicioDTO;
import com.veterinariasm.catalogo.model.Medicamento;
import com.veterinariasm.catalogo.model.Servicios;
import com.veterinariasm.catalogo.service.CatalogoService;


@RestController 
@RequestMapping ("/catalogo")
@CrossOrigin ("http://localhost:5173")
public class CatalogoController {
    @Autowired 
    private CatalogoService service;

    @GetMapping ("/medicamentos")
    public ResponseEntity<List<Medicamento>> listarMedicamentos(){
        try {
            List<Medicamento> lista=service.listarMedicamentos();
            if(lista.isEmpty()){
                return ResponseEntity.noContent().build();
            }else{
                return ResponseEntity.ok(lista);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping ("/servicios")
    public ResponseEntity<List<Servicios>> listarServicios(){
        try {
            List<Servicios> lista=service.listarServicios();
            if(lista.isEmpty()){
                return ResponseEntity.noContent().build();
            }else{
                return ResponseEntity.ok(lista);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping ("/medicamentos/{id}")
    public ResponseEntity<Medicamento> getMedicamentoById(@PathVariable Integer id){
        try {
            Medicamento medicamento=service.getMedicamentoById(id);
            if(medicamento.equals(null)){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(medicamento);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping ("/servicios/{id}")
    public ResponseEntity<Servicios> getServiciosById(@PathVariable Integer id){
        try {
            Servicios servicio=service.getServiciosById(id);
            if(servicio.equals(null)){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(servicio);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping (value = "/med-stock/{id}", method = {RequestMethod.PATCH, RequestMethod.POST})
    public ResponseEntity<Void> stockMedicamento(@PathVariable Integer id){
        try {
            Medicamento medicamento=service.stockMedicamento(id);
            if(medicamento.equals(null)){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.noContent().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //desde aqui: uso unico para admin
    @PutMapping ("/update/med")
    public ResponseEntity<Medicamento> updateMedicamento(@RequestBody MedicamentoDTO medicamento){
        try {
            Medicamento medicamento2=service.updateMedicamento(medicamento);
            if(medicamento2.equals(null)){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(medicamento2);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping ("/update/serv")
    public ResponseEntity<Servicios> updateServicios(@RequestBody ServicioDTO servicioDTO){
        try {
            Servicios servicio=service.updateServicios(servicioDTO);
            if(servicio.equals(null)){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(servicio);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping ("/medicamentos")
    public ResponseEntity<Medicamento> createMedicamento(@RequestBody MedicamentoDTO medCreateDTO){
        try {
            if(medCreateDTO.getCantidad()==null||medCreateDTO.getCategoria()==null||medCreateDTO.getNombre()==null||medCreateDTO.getPrecio()==null){
                return ResponseEntity.noContent().build();
            }else{
                Medicamento medicamento=service.createMedicamento(medCreateDTO);
                return ResponseEntity.ok(medicamento);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping ("/servicios")
    public ResponseEntity<Servicios> createServicio(@RequestBody ServicioDTO servCreateDTO){
        try {
            if(servCreateDTO.getCategoria()==null||servCreateDTO.getNombre()==null||servCreateDTO.getPrecio()==null){
                return ResponseEntity.noContent().build();
            }else{
                Servicios servicio=service.createServicio(servCreateDTO);
                return ResponseEntity.ok(servicio);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
