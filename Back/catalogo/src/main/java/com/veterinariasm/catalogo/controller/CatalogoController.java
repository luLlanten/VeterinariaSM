package com.veterinariasm.catalogo.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.veterinariasm.catalogo.dto.MedicamentoDTO;
import com.veterinariasm.catalogo.dto.ServicioDTO;
import com.veterinariasm.catalogo.model.Medicamento;
import com.veterinariasm.catalogo.model.Servicios;
import com.veterinariasm.catalogo.service.CatalogoService;


@RestController 
@RequestMapping ("/catalogo")
@CrossOrigin ("http://localhost:5173")
@Tag(name = "Catálogo", description = "Servicios y medicamentos de la veterinaria.")
public class CatalogoController {
    @Autowired 
    private CatalogoService service;

    @Operation(summary = "Listar medicamentos", description = "Devuelve todos los medicamentos. Responde 204 si no hay registros.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "204", description = "Sin contenido"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
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
    @Operation(summary = "Listar servicios", description = "Devuelve todos los servicios. Responde 204 si no hay registros.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "204", description = "Sin contenido"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
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

    @Operation(summary = "Obtener medicamento por id", description = "Devuelve el detalle de un medicamento.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @GetMapping ("/medicamentos/{id}")
    public ResponseEntity<Medicamento> getMedicamentoById(@Parameter(description = "Id del medicamento") @PathVariable Integer id){
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
    @Operation(summary = "Obtener servicio por id", description = "Devuelve el detalle de un servicio.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @GetMapping ("/servicios/{id}")
    public ResponseEntity<Servicios> getServiciosById(@Parameter(description = "Id del servicio") @PathVariable Integer id){
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

    @Operation(summary = "Descontar stock", description = "Resta una unidad al stock del medicamento. Lo usa el servicio de compras.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Sin contenido"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @PatchMapping ("/med-stock/{id}")
    public ResponseEntity<Void> stockMedicamento(@Parameter(description = "Id del medicamento") @PathVariable Integer id){
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
    @Operation(summary = "Actualizar medicamento (admin)", description = "Modifica nombre, categoría, precio y cantidad de un medicamento.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
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
    @Operation(summary = "Actualizar servicio (admin)", description = "Modifica nombre, categoría y precio de un servicio.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
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

    @Operation(summary = "Crear medicamento (admin)", description = "Agrega un medicamento. Exige nombre, categoría, precio y cantidad.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "204", description = "Sin contenido"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
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
    @Operation(summary = "Crear servicio (admin)", description = "Agrega un servicio. Exige nombre, categoría y precio.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "204", description = "Sin contenido"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
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
