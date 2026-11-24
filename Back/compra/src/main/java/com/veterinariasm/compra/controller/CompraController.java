package com.veterinariasm.compra.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veterinariasm.compra.dto.ProdCarritoDTO;
import com.veterinariasm.compra.model.Boleta;
import com.veterinariasm.compra.model.Carrito;
import com.veterinariasm.compra.model.MedCarrito;
import com.veterinariasm.compra.model.SerCarrito;
import com.veterinariasm.compra.service.CompraService;

@RestController 
@RequestMapping ("/compra")
@CrossOrigin ("http://localhost:5173")
@Tag(name = "Compras", description = "Carrito de compras (servicios y medicamentos), compra y boletas.")
public class CompraController {
    @Autowired 
    private CompraService service;

    @Operation(summary = "Crear carrito", description = "Crea el carrito de un usuario si aún no tiene uno.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Sin contenido"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    @PostMapping ("/{id}")
    public ResponseEntity<Carrito> crearCarrito(@Parameter(description = "Id del usuario dueño del carrito") @PathVariable Integer id){
        try {
            service.crearCarrito(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Realizar compra", description = "Genera la boleta, descuenta el stock de los medicamentos, devuelve los productos comprados y vacía el carrito.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @PostMapping ("/comprar")
    public ResponseEntity<List<ProdCarritoDTO>> comprar(@RequestBody Carrito carrito){
        try{
            List<ProdCarritoDTO>lista=service.comprar(carrito);
            service.vaciarCarrito(carrito.getId());
            return ResponseEntity.ok(lista);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Agregar servicio al carrito", description = "Consulta el servicio en el catálogo, lo agrega al carrito y actualiza cantidad y total.")
    @ApiResponses({
            @ApiResponse(responseCode = "202", description = "Solicitud aceptada"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @PostMapping ("/{idCarr}/agrserv/{idServ}")
    public ResponseEntity<Void> agregarServicio(@Parameter(description = "Id del carrito") @PathVariable Integer idCarr,@Parameter(description = "Id del servicio") @PathVariable Integer idServ){
        try {
            service.aniadirServicio(idServ, idCarr);
            return ResponseEntity.accepted().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @Operation(summary = "Ver servicios del carrito", description = "Lista los servicios elegidos en el carrito.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @GetMapping ("/{id}/agrserv")
    public ResponseEntity<List<SerCarrito>> verServicios(@Parameter(description = "Id del carrito") @PathVariable Integer id){
        try {
            List<SerCarrito>lista=service.verServiciosElegidos(id);
            return ResponseEntity.ok(lista);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @Operation(summary = "Ver medicamentos del carrito", description = "Lista los medicamentos elegidos en el carrito.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @GetMapping ("/{id}/agrmed")
    public ResponseEntity<List<MedCarrito>> verMedicamentos(@Parameter(description = "Id del carrito") @PathVariable Integer id){
        try {
            List<MedCarrito>lista=service.verMedicamentosElegidos(id);
            return ResponseEntity.ok(lista);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @Operation(summary = "Agregar medicamento al carrito", description = "Consulta el medicamento en el catálogo, lo agrega al carrito y actualiza cantidad y total.")
    @ApiResponses({
            @ApiResponse(responseCode = "202", description = "Solicitud aceptada"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @PostMapping ("/{idCarr}/agrmed/{idMed}")
    public ResponseEntity<Void> agregarMedicamento(@Parameter(description = "Id del carrito") @PathVariable Integer idCarr,@Parameter(description = "Id del medicamento") @PathVariable Integer idMed){
        try {
            service.aniadirMedicamento(idMed, idCarr);
            return ResponseEntity.accepted().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @Operation(summary = "Quitar servicio del carrito", description = "Elimina un servicio del carrito.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Sin contenido"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @DeleteMapping ("/{idCarr}/delserv/{idServ}")
    public ResponseEntity<Void> eliminarServicio(@Parameter(description = "Id del carrito") @PathVariable Integer idCarr,@Parameter(description = "Id del servicio") @PathVariable Integer idServ){
        try {
            service.eliminarServicio(idServ, idCarr);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @Operation(summary = "Quitar medicamento del carrito", description = "Elimina un medicamento del carrito.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Sin contenido"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @DeleteMapping ("/{idCarr}/delmed/{idMed}")
    public ResponseEntity<Void> eliminarMedicamento(@Parameter(description = "Id del carrito") @PathVariable Integer idCarr,@Parameter(description = "Id del medicamento") @PathVariable Integer idMed){
        try {
            service.eliminarMedicamento(idMed, idCarr);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    //comunicacion con admin
    @Operation(summary = "Listar boletas (admin)", description = "Devuelve todas las boletas emitidas.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "204", description = "Sin contenido")
    })
    @GetMapping ("/admin/boletas")
    public ResponseEntity<List<Boleta>> getAllBoletas(){
        try {
            return ResponseEntity.ok(service.todasLasBoletas());
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }
    @Operation(summary = "Listar carritos (admin)", description = "Devuelve todos los carritos.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "204", description = "Sin contenido")
    })
    @GetMapping("/admin/carritos")
    public ResponseEntity<List<Carrito>> getAllCarritos(){
        try{
            return ResponseEntity.ok(service.todosLosCarritos());
        }catch(Exception e){
            return ResponseEntity.noContent().build();
        }
    }
    @Operation(summary = "Obtener boleta por id (admin)", description = "Devuelve una boleta.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @GetMapping ("/admin/boletas/{id}")
    public ResponseEntity<Boleta> getBoleta(@Parameter(description = "Id de la boleta") @PathVariable Integer id){
        try {
            return ResponseEntity.ok(service.buscarBoleta(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @Operation(summary = "Boletas de un carrito (admin)", description = "Devuelve las boletas asociadas al carrito enviado.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "204", description = "Sin contenido")
    })
    @GetMapping ("/admin/boletas/carrito")
    public ResponseEntity<List<Boleta>> getBoletasByCarrito(@RequestBody Carrito carrito){
        try{
            return ResponseEntity.ok(service.buscarBoletasPorCarrito(carrito));
        }catch(Exception e){
            return ResponseEntity.noContent().build();
        }
    }
    @Operation(summary = "Obtener carrito por id (admin)", description = "Devuelve un carrito.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @GetMapping ("/admin/carrito/{id}")
    public ResponseEntity<Carrito> getCarritoById(@Parameter(description = "Id del carrito") @PathVariable Integer id){
        try {
            return ResponseEntity.ok(service.buscarCarritoPorId(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @Operation(summary = "Obtener carrito de un usuario (admin)", description = "Devuelve el carrito del usuario indicado.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @GetMapping ("/admin/carrito/user/{id}")
    public ResponseEntity<Carrito>getCarritoByUser(@Parameter(description = "Id del usuario") @PathVariable Integer id ){
        try {
            return ResponseEntity.ok(service.buscarCarritoPorUsuario(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


}
