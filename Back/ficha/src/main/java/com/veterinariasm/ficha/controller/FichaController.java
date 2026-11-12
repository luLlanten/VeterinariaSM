package com.veterinariasm.ficha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veterinariasm.ficha.dto.FichaCompletaDTO;
import com.veterinariasm.ficha.model.Ficha;
import com.veterinariasm.ficha.model.Mascota;
import com.veterinariasm.ficha.model.Necropsia;
import com.veterinariasm.ficha.service.FichaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController 
@RequestMapping ("/ficha")
public class FichaController {

    @Autowired 
    private FichaService fichaService;

    @PostMapping("/crear/ficha")
    public ResponseEntity<Mascota> crearFichaMascota(@RequestBody FichaCompletaDTO ficha) {
        try{
            Boolean creado = fichaService.crearFicha(ficha.getFicha());
            Mascota mascota = fichaService.crearMascota(ficha.getMascota(), creado);
            return ResponseEntity.ok(mascota);
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PatchMapping ("/editar/ficha/{id}")
    public ResponseEntity<Mascota> darAlta(@PathVariable Integer id){
        try{
            Mascota mascota = fichaService.darAlta(id);
            return ResponseEntity.ok(mascota);
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/ficha/{id}")
    public ResponseEntity<List<Mascota>> buscarMascotaPorId(@PathVariable Integer id) {
        try {
            List<Mascota> buscar = fichaService.buscarMascotaPorId(id);
            if (!buscar.equals(null)) 
                {return ResponseEntity.ok(buscar);}
            else{
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/ficha/{id}")
    public ResponseEntity<List<Ficha>> buscarFichaPorId(@PathVariable Integer id) {
        try {
            List<Ficha> buscar = fichaService.buscarFichaPorId(id);
            if (!buscar.equals(null)) 
                {return ResponseEntity.ok(buscar);}
            else{
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/necropsia/{id}")
    public ResponseEntity<Necropsia> buscarNecropsiaPorIdMascota(@PathVariable Integer id) {
        try {
            Necropsia buscar = fichaService.buscarNecropsiaPorIdMascota(id);
            if (!buscar.equals(null)) 
                {return ResponseEntity.ok(buscar);}
            else{
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/necropsia/{id}")
    public ResponseEntity<List<Necropsia>> buscarNecropsiaPorIdUsuario(@PathVariable Integer id) {
        try {
            List<Necropsia> buscar = fichaService.buscarNecropsiaPorIdUsuario(id);
            if (!buscar.equals(null)) 
                {return ResponseEntity.ok(buscar);}
            else{
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/editar/ficha/{id}")
    public ResponseEntity<Mascota> modificarMascota(@RequestBody Mascota mascota) {
        try {
            fichaService.modificarMascota(mascota);
            return ResponseEntity.accepted().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> desactivarCita(@PathVariable Integer id){
        try{
            fichaService.desactivarMascota(id);
            return ResponseEntity.noContent().build();
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    } 

}
