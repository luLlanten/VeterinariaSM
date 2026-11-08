package com.veterinariasm.compra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public class CompraController {
    @Autowired 
    private CompraService service;

    @PostMapping ("/{id}")
    public ResponseEntity<Carrito> crearCarrito(@PathVariable Integer id){
        try {
            service.crearCarrito(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

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

    @PostMapping ("/{idCarr}/agrserv/{idServ}")
    public ResponseEntity<Void> agregarServicio(@PathVariable Integer idCarr,@PathVariable Integer idServ){
        try {
            service.aniadirServicio(idServ, idCarr);
            return ResponseEntity.accepted().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping ("/{id}/agrserv")
    public ResponseEntity<List<SerCarrito>> verServicios(@PathVariable Integer id){
        try {
            List<SerCarrito>lista=service.verServiciosElegidos(id);
            return ResponseEntity.ok(lista);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping ("/{id}/agrmed")
    public ResponseEntity<List<MedCarrito>> verMedicamentos(@PathVariable Integer id){
        try {
            List<MedCarrito>lista=service.verMedicamentosElegidos(id);
            return ResponseEntity.ok(lista);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping ("/{idCarr}/agrmed/{idMed}")
    public ResponseEntity<Void> agregarMedicamento(@PathVariable Integer idCarr,@PathVariable Integer idMed){
        try {
            service.aniadirMedicamento(idMed, idCarr);
            return ResponseEntity.accepted().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping ("/{idCarr}/delserv/{idServ}")
    public ResponseEntity<Void> eliminarServicio(@PathVariable Integer idCarr,@PathVariable Integer idServ){
        try {
            service.eliminarServicio(idServ, idCarr);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping ("/{idCarr}/delmed/{idMed}")
    public ResponseEntity<Void> eliminarMedicamento(@PathVariable Integer idCarr,@PathVariable Integer idMed){
        try {
            service.eliminarMedicamento(idMed, idCarr);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    //comunicacion con admin
    @GetMapping ("/admin/boletas")
    public ResponseEntity<List<Boleta>> getAllBoletas(){
        try {
            return ResponseEntity.ok(service.todasLasBoletas());
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }
    @GetMapping("/admin/carritos")
    public ResponseEntity<List<Carrito>> getAllCarritos(){
        try{
            return ResponseEntity.ok(service.todosLosCarritos());
        }catch(Exception e){
            return ResponseEntity.noContent().build();
        }
    }
    @GetMapping ("/admin/boletas/{id}")
    public ResponseEntity<Boleta> getBoleta(@PathVariable Integer id){
        try {
            return ResponseEntity.ok(service.buscarBoleta(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping ("/admin/boletas/carrito")
    public ResponseEntity<List<Boleta>> getBoletasByCarrito(@RequestBody Carrito carrito){
        try{
            return ResponseEntity.ok(service.buscarBoletasPorCarrito(carrito));
        }catch(Exception e){
            return ResponseEntity.noContent().build();
        }
    }
    @GetMapping ("/admin/carrito/{id}")
    public ResponseEntity<Carrito> getCarritoById(@PathVariable Integer id){
        try {
            return ResponseEntity.ok(service.buscarCarritoPorId(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping ("/admin/carrito/user/{id}")
    public ResponseEntity<Carrito>getCarritoByUser(@PathVariable Integer id ){
        try {
            return ResponseEntity.ok(service.buscarCarritoPorUsuario(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


}
