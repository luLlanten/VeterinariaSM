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

import com.veterinariasm.admin.dto.AdminDTO;
import com.veterinariasm.admin.dto.BoletaDTO;
import com.veterinariasm.admin.dto.CarritoDTO;
import com.veterinariasm.admin.dto.CitaDTO;
import com.veterinariasm.admin.dto.CitaHistorialDTO;
import com.veterinariasm.admin.dto.FichaDTO;
import com.veterinariasm.admin.dto.MascotaDTO;
import com.veterinariasm.admin.dto.MedCreateDTO;
import com.veterinariasm.admin.dto.MedicamentoDTO;
import com.veterinariasm.admin.dto.NecropsiaDTO;
import com.veterinariasm.admin.dto.ServCreateDTO;
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
    @GetMapping ("/user/admin/{id}")
    public ResponseEntity<AdminDTO> findAdminById(@PathVariable Integer id){
        try {
            AdminDTO adminDTO=service.getAdminById(id);
            if(adminDTO.equals(null)){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(adminDTO);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping ("/user/user/{id}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable Integer id){
        try {
             UserDTO user=service.getUserById(id);
            if(user.equals(null)){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(user);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping ("/user/users")
    public ResponseEntity<List<UserDTO>>listUsers(){
        try {
            List<UserDTO> lista=service.allUsers();
            if(lista.isEmpty()){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(lista);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping ("/user/admins")
    public ResponseEntity<List<AdminDTO>>listAdmins(){
        try {
            List<AdminDTO> lista=service.allAdmins();
            if(lista.isEmpty()){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(lista);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @PatchMapping ("/user/user/veterinario/{id}")
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


    //ficha
    @GetMapping("/ficha/mascota/user/{id}")
    public ResponseEntity<List<MascotaDTO>> buscarMascotaPorUser(@PathVariable Integer id){
        try {
            List<MascotaDTO> lista=service.buscarMascotaPorUser(id);
            if(lista.isEmpty()){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(lista);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/ficha/user/{id}")
    public ResponseEntity<List<FichaDTO>>buscarFichaPorIdUser(@PathVariable Integer id){
        try {
            List<FichaDTO> lista=service.buscarFichaPorIdUser(id);
            if(lista.isEmpty()){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(lista);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/ficha/necropsia/mascota/{id}")
    public ResponseEntity<NecropsiaDTO> buscarNecropsiaPorIdMascota(@PathVariable Integer id){
        try {
            NecropsiaDTO necropsiaDTO=service.buscarNecropsiaPorIdMascota(id);
            if(necropsiaDTO.equals(null)){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(necropsiaDTO);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/ficha/necropsia/user/{id}")
    public ResponseEntity<List<NecropsiaDTO>>buscarNecropsiaPorIdUsuario(@PathVariable Integer id){
        try {
            List<NecropsiaDTO> lista=service.buscarNecropsiaPorIdUsuario(id);
            if(lista.isEmpty()){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(lista);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping ("/ficha/{id}")
    public ResponseEntity<FichaDTO> getFichaById(@PathVariable Integer id){
        try {
            FichaDTO fichaDTO=service.getFichaById(id);
            if(fichaDTO.equals(null)){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(fichaDTO);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/ficha")
    public ResponseEntity<List<FichaDTO>>getAllFicha(){
        try {
            List<FichaDTO> lista=service.getAllFicha();
            if(lista.isEmpty()){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(lista);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping ("/ficha/mascota/{id}")
    public ResponseEntity<MascotaDTO> getMascotaPorId(@PathVariable Integer id){
        try {
            MascotaDTO mascotaDTO=service.getMascotaPorId(id);
            if(mascotaDTO.equals(null)){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(mascotaDTO);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping ("/ficha/mascota")
    public ResponseEntity<List<MascotaDTO>>getAllMascota(){
        try {
            List<MascotaDTO> lista=service.getAllMascota();
            if(lista.isEmpty()){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(lista);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/ficha/necropsia/{id}")
    public ResponseEntity<NecropsiaDTO> getNecropsiaPorId(@PathVariable Integer id){
        try {
            NecropsiaDTO necropsiaDTO=service.getNecropsiaPorId(id);
            if(necropsiaDTO.equals(null)){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(necropsiaDTO);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping ("/ficha/necropsia")
    public ResponseEntity<List<NecropsiaDTO>> getAllNecropsia(){
        try {
            List<NecropsiaDTO> lista=service.getAllNecropsia();
            if(lista.isEmpty()){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(lista);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


    //compra
    @GetMapping ("/compra/admin/boletas")
    public ResponseEntity<List<BoletaDTO>> getAllBoletas(){
        try {
            List<BoletaDTO> lista=service.getAllBoletas();
            if(lista.isEmpty()){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(lista);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping ("/compra/admin/carritos")
    public ResponseEntity<List<CarritoDTO>> getAllCarritos(){
        try {
            List<CarritoDTO> lista=service.getAllCarritos();
            if(lista.isEmpty()){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(lista);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping ("/compra/admin/boletas/{id}")
    public ResponseEntity<BoletaDTO> getBoleta(@PathVariable Integer id){
        try {
            BoletaDTO boletaDTO=service.getBoleta(id);
            if(boletaDTO.equals(null)){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(boletaDTO);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping ("/compra/admin/boletas/carrito")
    public ResponseEntity<List<BoletaDTO>> getBoletasByCarrito(@RequestBody CarritoDTO carrito){
        try {
            List<BoletaDTO> lista=service.getBoletasByCarrito(carrito);
            if(lista.isEmpty()){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(lista);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping ("/compra/admin/carrito/{id}")
    public ResponseEntity<CarritoDTO> getCarritoById(@PathVariable Integer id){
        try {
            CarritoDTO carritoDTO=service.getCarritoById(id);
            if(carritoDTO.equals(null)){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(carritoDTO);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping ("/compra/admin/carrito/user/{id}")
    public ResponseEntity<CarritoDTO> getCarritoByUser(@PathVariable Integer id ){
        try {
            CarritoDTO carritoDTO=service.getCarritoByUser(id);
            if(carritoDTO.equals(null)){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(carritoDTO);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


    //cita
    @GetMapping("/cita/{id}")
    public ResponseEntity<CitaDTO> buscarCitaPorId(@PathVariable Integer id){
        try {
            CitaDTO citaDTO=service.buscarCitaPorId(id);
            if(citaDTO.equals(null)){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(citaDTO);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/cita/user/{id}")
    public ResponseEntity<List<CitaDTO>> buscarCitasPorUsuario(@PathVariable Integer id){
        try {
            List<CitaDTO> lista=service.buscarCitasPorUsuario(id);
            if(lista.isEmpty()){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(lista);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/cita/user/historial")
    public ResponseEntity<CitaHistorialDTO> buscarHistorialPorUsuario(@RequestBody CitaDTO cita){
        try {
            CitaHistorialDTO citaDTO=service.buscarHistorialPorUsuario(cita);
            if(citaDTO.equals(null)){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(citaDTO);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //catalogo
    @GetMapping ("/catalogo/medicamentos")
    public ResponseEntity<List<MedicamentoDTO>> listarMedicamentos(){
        try {
            List<MedicamentoDTO> lista=service.listarMedicamentos();
            if(lista.isEmpty()){
                return ResponseEntity.noContent().build();
            }else{
                return ResponseEntity.ok(lista);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping ("/catalogo/servicios")
    public ResponseEntity<List<ServicioDTO>> listarServicios(){
        try {
            List<ServicioDTO> lista=service.listarServicios();
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
    public ResponseEntity<MedicamentoDTO> getMedicamentoById(@PathVariable Integer id){
        try {
            MedicamentoDTO medicamentoDTO=service.getMedicamentoById(id);
            if(medicamentoDTO.equals(null)){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(medicamentoDTO);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping ("/servicios/{id}")
    public ResponseEntity<ServicioDTO> getServicioById(@PathVariable Integer id){
        try {
            ServicioDTO servicioDTO=service.getServiciosById(id);
            if(servicioDTO.equals(null)){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(servicioDTO);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
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
    @PutMapping ("/update/med")
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
    public ResponseEntity<MedicamentoDTO> createMedicamento(@RequestBody MedCreateDTO medCreateDTO,@RequestParam Integer idAdmin){
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
    public ResponseEntity<ServicioDTO> createServicio(@RequestBody ServCreateDTO servCreateDTO,@RequestParam Integer idAdmin){
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
