package com.veterinariasm.admin.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.veterinariasm.admin.dto.MedicamentoDTO;

import com.veterinariasm.admin.dto.ServicioDTO;
import com.veterinariasm.admin.dto.UserDTO;
import com.veterinariasm.admin.model.Log;
import com.veterinariasm.admin.service.LogService;

@RestController 
@RequestMapping ("/administracion")
@CrossOrigin ("http://localhost:5173")
@Tag(name = "Administración", description = "Gestión del catálogo y de roles por parte del administrador, y bitácora de acciones.")
public class LogController {
    @Autowired 
    private LogService service;

    //user
    @Operation(summary = "Asignar rol de veterinario", description = "Convierte a un usuario en veterinario y registra la acción en la bitácora con el id del administrador.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @PatchMapping ("/set-veterinario/{id}")
    public ResponseEntity<UserDTO> setVeterinario(@Parameter(description = "Id del usuario") @PathVariable Integer id,@Parameter(description = "Id del administrador que realiza la acción") @RequestParam Integer admin){
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
    @Operation(summary = "Actualizar medicamento", description = "Modifica un medicamento del catálogo en nombre del administrador indicado.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @PutMapping ("/update/med")
    public ResponseEntity<MedicamentoDTO> updateMedicamento(@RequestBody MedicamentoDTO medicamento,@Parameter(description = "Id del administrador que realiza la acción") @RequestParam Integer idAdmin){
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
    @Operation(summary = "Actualizar servicio", description = "Modifica un servicio del catálogo en nombre del administrador indicado.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @PutMapping ("/update/serv")
    public ResponseEntity<ServicioDTO> updateServicios(@RequestBody ServicioDTO servicioDTO,@Parameter(description = "Id del administrador que realiza la acción") @RequestParam Integer idAdmin){
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
    @Operation(summary = "Crear medicamento", description = "Agrega un medicamento al catálogo en nombre del administrador indicado.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "204", description = "Sin contenido"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    @PostMapping ("/medicamentos")
    public ResponseEntity<MedicamentoDTO> createMedicamento(@RequestBody MedicamentoDTO medCreateDTO,@Parameter(description = "Id del administrador que realiza la acción") @RequestParam Integer idAdmin){
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
    @Operation(summary = "Crear servicio", description = "Agrega un servicio al catálogo en nombre del administrador indicado.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "204", description = "Sin contenido"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    @PostMapping ("/servicios")
    public ResponseEntity<ServicioDTO> createServicio(@RequestBody ServicioDTO servCreateDTO,@Parameter(description = "Id del administrador que realiza la acción") @RequestParam Integer idAdmin){
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
    @Operation(summary = "Listar bitácora", description = "Devuelve todos los registros de la bitácora.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "204", description = "Sin contenido"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
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
    @Operation(summary = "Obtener registro de bitácora por id", description = "Devuelve un registro de la bitácora.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @GetMapping ("/log/{id}")
    public ResponseEntity<Log> getLogById(@Parameter(description = "Id del registro de la bitácora") Integer id){
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
    @Operation(summary = "Bitácora de un administrador", description = "Devuelve los registros hechos por el administrador indicado.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "204", description = "Sin contenido"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    @GetMapping ("/log/admin/{id}")
    public ResponseEntity<List<Log>>getLogsByAdmin(@Parameter(description = "Id del administrador") Integer id){
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
    @Operation(summary = "Bitácora por acción", description = "Devuelve los registros de una acción (por ejemplo, setVet).")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "204", description = "Sin contenido"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    @GetMapping ("/log/ruta/{id}")
    public ResponseEntity<List<Log>>getLogdByRuta(@Parameter(description = "Nombre de la acción registrada en la bitácora (por ejemplo, setVet)") String ruta){
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
