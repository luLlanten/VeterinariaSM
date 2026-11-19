package com.veterinariasm.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.veterinariasm.admin.dto.MedicamentoDTO;

import com.veterinariasm.admin.dto.ServicioDTO;
import com.veterinariasm.admin.dto.UserDTO;
import com.veterinariasm.admin.model.Log;
import com.veterinariasm.admin.service.LogService;

@RestController 
@RequestMapping ("/administracion")
public class LogController {
    @Autowired 
    private LogService service;

    //user
    @PatchMapping ("/set-veterinario/{id}")
    public ResponseEntity<UserDTO> setVeterinario(@PathVariable Integer id,@RequestParam Integer admin){
        try {
             UserDTO user=service.setVet(id, admin);
            if(user.equals(null)){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(user);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    //catalogo
    @PutMapping ("/update/med")
    public ResponseEntity<MedicamentoDTO> updateMedicamento(@RequestBody MedicamentoDTO medicamento,@RequestParam Integer idAdmin){
        try {
            MedicamentoDTO medicamentoDTO=service.updateMedicamento(medicamento, idAdmin);
            if(medicamentoDTO.equals(null)){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(medicamentoDTO);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping ("/update/serv")
    public ResponseEntity<ServicioDTO> updateServicios(@RequestBody ServicioDTO servicioDTO,@RequestParam Integer idAdmin){
        try {
            ServicioDTO servicioDTO2=service.updateServicios(servicioDTO, idAdmin);
            if(servicioDTO2.equals(null)){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(servicioDTO2);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping ("/medicamentos")
    public ResponseEntity<MedicamentoDTO> createMedicamento(@RequestBody MedicamentoDTO medCreateDTO,@RequestParam Integer idAdmin){
        try {
            MedicamentoDTO medicamentoDTO=service.createMedicamento(medCreateDTO, idAdmin);
            if(medicamentoDTO.equals(null)){
                return ResponseEntity.noContent().build();
            }else{
                return ResponseEntity.ok(medicamentoDTO);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping ("/servicios")
    public ResponseEntity<ServicioDTO> createServicio(@RequestBody ServicioDTO servCreateDTO,@RequestParam Integer idAdmin){
        try {
            ServicioDTO servicioDTO=service.createServicio(servCreateDTO, idAdmin);
            if(servicioDTO.equals(null)){
                return ResponseEntity.noContent().build();
            }else{
                return ResponseEntity.ok(servicioDTO);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


    //admin
    @GetMapping ("/log")
    public ResponseEntity<List<Log>> getAllLogs(){
        try {
            List<Log> lista=service.getAllLogs();
            if(lista.isEmpty()){
                return ResponseEntity.noContent().build();
            }else{
                return ResponseEntity.ok(lista);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping ("/log/{id}")
    public ResponseEntity<Log> getLogById(Integer id){
        try {
            Log log=service.getLogById(id);
            if(log.equals(null)){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(log);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        
    }
    @GetMapping ("/log/admin/{id}")
    public ResponseEntity<List<Log>>getLogsByAdmin(Integer id){
        try {
            List<Log> lista=service.getLogsByAdmin(id);
            if(lista.isEmpty()){
                return ResponseEntity.noContent().build();
            }else{
                return ResponseEntity.ok(lista);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping ("/log/ruta/{id}")
    public ResponseEntity<List<Log>>getLogdByRuta(String ruta){
        try {
            List<Log> lista=service.getLogdByRuta(ruta);
            if(lista.isEmpty()){
                return ResponseEntity.noContent().build();
            }else{
                return ResponseEntity.ok(lista);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
