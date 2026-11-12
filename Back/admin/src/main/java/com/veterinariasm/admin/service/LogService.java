package com.veterinariasm.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.veterinariasm.admin.client.CitaClient;
import com.veterinariasm.admin.client.CompraClient;
import com.veterinariasm.admin.client.FichaClient;
import com.veterinariasm.admin.client.LobbyClient;
import com.veterinariasm.admin.dto.AdminDTO;
import com.veterinariasm.admin.dto.BoletaDTO;
import com.veterinariasm.admin.dto.CarritoDTO;
import com.veterinariasm.admin.dto.CitaDTO;
import com.veterinariasm.admin.dto.CitaHistorialDTO;
import com.veterinariasm.admin.dto.FichaDTO;
import com.veterinariasm.admin.dto.MascotaDTO;
import com.veterinariasm.admin.dto.NecropsiaDTO;
import com.veterinariasm.admin.dto.UserDTO;
import com.veterinariasm.admin.model.Log;
import com.veterinariasm.admin.repo.LogRepo;

@Service 
public class LogService {
    @Autowired 
    private LogRepo repo;

    @Autowired 
    private LobbyClient lobbyClient;

    @Autowired 
    private CompraClient compraClient;

    @Autowired 
    private CitaClient citaClient;

    @Autowired 
    private FichaClient fichaClient;

    //Users
    public AdminDTO getAdminById(Integer id){
        return lobbyClient.findAdminById(id);
    }
    public UserDTO getUserById(Integer id){
        return lobbyClient.findUserById(id);
    }
    public List<AdminDTO> allAdmins(){
        return lobbyClient.listAdmins();
    }
    public List<UserDTO>allUsers(){
        return lobbyClient.listUsers();
    }
    public UserDTO setVet(Integer idUser,Integer idAdmin){
        Log log=new Log();
        log.setMensaje("El usuario "+idUser+"ha sido asignado como veterinario");
        log.setRuta("setVet");
        log.setAdminId(idAdmin);
        repo.save(log);
        return lobbyClient.setVeterinario(idUser);
    }


    //Fichas
    public List<MascotaDTO> buscarMascotaPorUser(Integer id){
        return fichaClient.buscarMascotaPorUser(id);
    }
    public List<FichaDTO>buscarFichaPorIdUser(Integer id){
        return fichaClient.buscarFichaPorIdUser(id);
    }
    public NecropsiaDTO buscarNecropsiaPorIdMascota(Integer id){
        return fichaClient.buscarNecropsiaPorIdMascota(id);
    }
    public List<NecropsiaDTO>buscarNecropsiaPorIdUsuario(Integer id){
        return fichaClient.buscarNecropsiaPorIdUsuario(id);
    }
    public FichaDTO getFichaById(Integer id){
        return fichaClient.getFichaById(id);
    }
    public List<FichaDTO>getAllFicha(){
        return fichaClient.getAllFicha();
    }
    public MascotaDTO getMascotaPorId(Integer id){
        return fichaClient.getMascotaPorId(id);
    }
    public List<MascotaDTO>getAllMascota(){
        return fichaClient.getAllMascota();
    }
    public NecropsiaDTO getNecropsiaPorId(Integer id){
        return fichaClient.getNecropsiaPorId(id);
    }
    public List<NecropsiaDTO> getAllNecropsia(){
        return fichaClient.getAllNecropsia();
    }
    
    
    //compra
    public List<BoletaDTO> getAllBoletas(){
        return compraClient.getAllBoletas();
    }
    public List<CarritoDTO> getAllCarritos(){
        return compraClient.getAllCarritos();
    }
    public BoletaDTO getBoleta(Integer id){
        return compraClient.getBoleta(id);
    }
    public List<BoletaDTO> getBoletasByCarrito(CarritoDTO carrito){
        return compraClient.getBoletasByCarrito(carrito);
    }
    public CarritoDTO getCarritoById(Integer id){
        return compraClient.getCarritoById(id);
    }
    public CarritoDTO getCarritoByUser( Integer id ){
        return compraClient.getCarritoByUser(id);
    }


    //citas
    public CitaDTO buscarCitaPorId(Integer id){
        return citaClient.buscarCitaPorId(id);
    }
    public List<CitaDTO> buscarCitasPorUsuario(Integer id){
        return citaClient.buscarCitasPorUsuario(id);
    }
    public CitaHistorialDTO buscarHistorialPorUsuario(CitaDTO cita){
        return citaClient.buscarHistorialPorUsuario(cita);
    }


    //catalogo




    //admin
    public List<Log> getAllLogs(){
        return repo.findAll();
    }
    public Log getLogById(Integer id){
        return repo.findById(id).get();
    }
    public List<Log>getLogsByAdmin(Integer id){
        return repo.findByAdminId(id);
    }
    public List<Log>getLogdByRuta(String ruta){
        return repo.findByRuta(ruta);
    }

    

}
