package com.veterinariasm.citas.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veterinariasm.citas.dto.ServicioRegistroDTO;
import com.veterinariasm.citas.model.Cita;
import com.veterinariasm.citas.model.CitaHistorial;
import com.veterinariasm.citas.service.CitaService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/citas")
@CrossOrigin ("http://localhost:5173")
@Tag(name = "Citas", description = "Agendamiento, modificación, cancelación e historial de citas.")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @Operation(summary = "Agendar cita", description = "Crea una cita para un usuario y un servicio en la fecha indicada. Consulta al usuario y al servicio en los otros microservicios.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @PostMapping("/crear/{idUser}/{idServicio}")
    public ResponseEntity<Cita> crearCita(@Parameter(description = "Id del usuario") @PathVariable Integer idUser, @Parameter(description = "Id del servicio") @PathVariable Integer idServicio,@RequestBody Date fecha) {
        try{
            ServicioRegistroDTO serv=citaService.linkear(idUser, idServicio);
            if(!serv.equals(null)){
                serv=citaService.registrarFecha(fecha,serv);
                Cita cita = citaService.crearCitaServicio(serv);
                return ResponseEntity.ok(cita);
            }else{
                return ResponseEntity.notFound().build();
            }
        }
        catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Guardar en el historial", description = "Registra una cita en el historial con su fecha de registro y de cita.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    @PostMapping("/historial")
    public ResponseEntity<CitaHistorial> guardarHistorial(@RequestBody Cita cita) {
        try {
            CitaHistorial nuevoHistorial = citaService.guardarHistorial(cita);
            return ResponseEntity.ok(nuevoHistorial);    
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        
    }

    @Operation(summary = "Obtener historial por id", description = "Devuelve un registro del historial de citas.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @GetMapping("/historial/{id}")
    public ResponseEntity<CitaHistorial> buscarHistorialPorId(@Parameter(description = "Id del historial") @PathVariable Integer id) {
        try{
            CitaHistorial buscar = citaService.buscarHistorialPorId(id);
            if(!buscar.equals(null))
                {return ResponseEntity.ok(buscar);}
            else{
                return ResponseEntity.notFound().build();
            }
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Obtener cita por id", description = "Devuelve los datos de una cita.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Cita> buscarCitaPorId(@Parameter(description = "Id de la cita") @PathVariable Integer id) {
        try{
            Cita buscar = citaService.buscarCitaPorId(id);
            if(!buscar.equals(null)){
                return ResponseEntity.ok(buscar);
            }else{
                return ResponseEntity.notFound().build();
            }
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Listar citas de un usuario", description = "Devuelve todas las citas del usuario indicado.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "204", description = "Sin contenido")
    })
    @GetMapping("/user/{id}")
    public ResponseEntity<List<Cita>> buscarCitasPorUsuario(@Parameter(description = "Id del usuario") @PathVariable Integer id) {
        try{
            List<Cita> buscar = citaService.buscarCitasPorUsuario(id);
            return ResponseEntity.ok(buscar);
        }catch(Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    @Operation(summary = "Obtener historial de una cita", description = "Devuelve el historial asociado a la cita enviada.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @GetMapping("/user/historial")
    public ResponseEntity<CitaHistorial> buscarHistorialPorUsuario(@RequestBody Cita cita) {
        try{
            CitaHistorial buscar = citaService.buscarHistorialPorUsuario(cita);
            if(!buscar.equals(null)){
                return ResponseEntity.ok(buscar);
            }else{
                return ResponseEntity.notFound().build();
            }
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Modificar cita", description = "Cambia la fecha de una cita existente.")
    @ApiResponses({
            @ApiResponse(responseCode = "202", description = "Solicitud aceptada"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @PutMapping("/modificar")
    public ResponseEntity<Void> modificarCita(@RequestBody Cita cita) {
        try{
            citaService.modificarCita(cita);
            return ResponseEntity.accepted().build();
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Cancelar cita", description = "Marca la cita como no vigente. No borra el registro.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Sin contenido"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @PatchMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarCita(@Parameter(description = "Id de la cita") @PathVariable Integer id){
        try{
            citaService.eliminarCita(id);
            return ResponseEntity.noContent().build();
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    } 
    
    

}