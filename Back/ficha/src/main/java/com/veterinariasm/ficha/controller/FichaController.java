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

    @PostMapping("/crear")
    public ResponseEntity<Mascota> crearFichaMascota(@RequestBody FichaCompletaDTO ficha) {
        try{
            Boolean creado = fichaService.crearFicha(ficha.getFicha());
            Mascota mascota = fichaService.crearMascota(ficha.getMascota(), creado);
            return ResponseEntity.ok(mascota);
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PatchMapping ("/editar-ficha/{id}")
    public ResponseEntity<Mascota> darAlta(@PathVariable Integer id){
        try{
            Mascota mascota = fichaService.darAlta(id);
            return ResponseEntity.ok(mascota);
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/mascota/user/{id}")
    public ResponseEntity<List<Mascota>> buscarMascotaPorUser(@PathVariable Integer id) {
        try {
            List<Mascota> buscar = fichaService.buscarMascotaPorUsuario(id);
            if (!buscar.equals(null)) 
                {return ResponseEntity.ok(buscar);}
            else{
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Ficha>> buscarFichaPorIdUser(@PathVariable Integer id) {
        try {
            List<Ficha> buscar = fichaService.buscarFichaPorUsuario(id);
            if (!buscar.equals(null)) 
                {return ResponseEntity.ok(buscar);}
            else{
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/necropsia/mascota/{id}")
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

    @GetMapping("/necropsia/user/{id}")
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

    @PutMapping("/editar-mascota/{id}")
    public ResponseEntity<Mascota> modificarMascota(@RequestBody Mascota mascota) {
        try {
            fichaService.modificarMascota(mascota);
            return ResponseEntity.accepted().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> desactivarMascota(@PathVariable Integer id){
        try{
            fichaService.desactivarMascota(id);
            return ResponseEntity.noContent().build();
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    } 

    @GetMapping ("/{id}")
    public ResponseEntity<Ficha> getFichaById(@PathVariable Integer id){
        try {
            Ficha ficha=fichaService.buscarFichaPorId(id);
            if (ficha.equals(null)){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(ficha);
            }
             
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping
    public ResponseEntity<List<Ficha>>getAllFicha(){
        List<Ficha> lista=fichaService.todasLasFichas();
        if(lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(lista);
        }
    }
    @GetMapping ("/mascota/{id}")
    public ResponseEntity<Mascota>getMascotaPorId(@PathVariable Integer id){
        try {
            Mascota mascota=fichaService.buscarMascotaPorId(id);
            if (mascota.equals(null)){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(mascota);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping ("/mascota")
    public ResponseEntity<List<Mascota>>getAllMascota(){
        List<Mascota> lista=fichaService.todasLasMascotas();
        if(lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(lista);
        }
    }
    @GetMapping("/necropsia/{id}")
    public ResponseEntity<Necropsia>getNecropsiaPorId(@PathVariable Integer id){
        try {
            Necropsia necropsia=fichaService.buscarNecropsiaPorId(id);
            if (necropsia.equals(null)){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(necropsia);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping ("/necropsia")
    public ResponseEntity<List<Necropsia>>getAllNecropsia(){
        List<Necropsia> lista=fichaService.todasLasNecropsias();
        if(lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(lista);
        }
    }

}
