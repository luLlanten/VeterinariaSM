package com.veterinariasm.ficha.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

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

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController 
@RequestMapping ("/ficha")
@CrossOrigin ("http://localhost:5173")
@Tag(name = "Fichas clínicas", description = "Mascotas, fichas clínicas y necropsias.")
public class FichaController {

    @Autowired 
    private FichaService fichaService;

    @Operation(summary = "Crear ficha y mascota", description = "Registra la ficha clínica con sus antecedentes y la mascota.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
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

    @Operation(summary = "Registrar necropsia", description = "Registra la necropsia de una mascota (una por mascota).")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    @PostMapping("/necropsia")
    public ResponseEntity<Necropsia>crearNecropsia(@RequestBody Necropsia necropsia) {
        try {
            Necropsia nuevo = fichaService.crearNecropsia(necropsia);
            return ResponseEntity.ok(nuevo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    
    @Operation(summary = "Dar de alta a la mascota", description = "Registra la fecha de alta de la mascota.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    @PatchMapping ("/editar-ficha/{id}")
    public ResponseEntity<Mascota> darAlta(@Parameter(description = "Id de la mascota") @PathVariable Integer id){
        try{
            Mascota mascota = fichaService.darAlta(id);
            return ResponseEntity.ok(mascota);
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Mascotas de un usuario", description = "Lista las mascotas del usuario indicado.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @GetMapping("/mascota/user/{id}")
    public ResponseEntity<List<Mascota>> buscarMascotaPorUser(@Parameter(description = "Id del usuario") @PathVariable Integer id) {
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

    @Operation(summary = "Fichas de un usuario", description = "Lista las fichas del usuario indicado.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @GetMapping("/user/{id}")
    public ResponseEntity<List<Ficha>> buscarFichaPorIdUser(@Parameter(description = "Id del usuario") @PathVariable Integer id) {
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

    @Operation(summary = "Necropsia de una mascota", description = "Devuelve la necropsia de la mascota indicada.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @GetMapping("/necropsia/mascota/{id}")
    public ResponseEntity<Necropsia> buscarNecropsiaPorIdMascota(@Parameter(description = "Id de la mascota") @PathVariable Integer id) {
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

    @Operation(summary = "Necropsias de un usuario", description = "Lista las necropsias del usuario indicado.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @GetMapping("/necropsia/user/{id}")
    public ResponseEntity<List<Necropsia>> buscarNecropsiaPorIdUsuario(@Parameter(description = "Id del usuario") @PathVariable Integer id) {
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

    @Operation(summary = "Modificar mascota", description = "Actualiza peso, tamaño y estado de la mascota.")
    @ApiResponses({
            @ApiResponse(responseCode = "202", description = "Solicitud aceptada"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @PutMapping("/editar-mascota/{id}")
    public ResponseEntity<Mascota> modificarMascota(@RequestBody Mascota mascota) {
        try {
            fichaService.modificarMascota(mascota);
            return ResponseEntity.accepted().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Desactivar mascota", description = "Marca la mascota como inactiva.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Sin contenido"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> desactivarMascota(@Parameter(description = "Id de la mascota") @PathVariable Integer id){
        try{
            fichaService.desactivarMascota(id);
            return ResponseEntity.noContent().build();
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    } 

    @Operation(summary = "Obtener ficha por id", description = "Devuelve una ficha clínica.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @GetMapping ("/{id}")
    public ResponseEntity<Ficha> getFichaById(@Parameter(description = "Id de la ficha") @PathVariable Integer id){
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
    @Operation(summary = "Listar fichas", description = "Devuelve todas las fichas.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "204", description = "Sin contenido")
    })
    @GetMapping
    public ResponseEntity<List<Ficha>>getAllFicha(){
        List<Ficha> lista=fichaService.todasLasFichas();
        if(lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(lista);
        }
    }
    @Operation(summary = "Obtener mascota por id", description = "Devuelve una mascota.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @GetMapping ("/mascota/{id}")
    public ResponseEntity<Mascota>getMascotaPorId(@Parameter(description = "Id de la mascota") @PathVariable Integer id){
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
    @Operation(summary = "Listar mascotas", description = "Devuelve todas las mascotas.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "204", description = "Sin contenido")
    })
    @GetMapping ("/mascota")
    public ResponseEntity<List<Mascota>>getAllMascota(){
        List<Mascota> lista=fichaService.todasLasMascotas();
        if(lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(lista);
        }
    }
    @Operation(summary = "Obtener necropsia por id", description = "Devuelve una necropsia.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @GetMapping("/necropsia/{id}")
    public ResponseEntity<Necropsia>getNecropsiaPorId(@Parameter(description = "Id de la necropsia") @PathVariable Integer id){
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
    @Operation(summary = "Listar necropsias", description = "Devuelve todas las necropsias.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "204", description = "Sin contenido")
    })
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
