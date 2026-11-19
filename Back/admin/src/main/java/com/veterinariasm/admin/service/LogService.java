package com.veterinariasm.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinariasm.admin.client.CatalogoClient;
import com.veterinariasm.admin.client.LobbyClient;
import com.veterinariasm.admin.dto.MedicamentoDTO;
import com.veterinariasm.admin.dto.ServicioDTO;
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
    private CatalogoClient catalogoClient;

    //Users
    public UserDTO setVet(Integer idUser,Integer idAdmin){
        Log log=new Log();
        log.setMensaje("El usuario "+idUser+"ha sido asignado como veterinario");
        log.setRuta("setVet");
        log.setAdminId(idAdmin);
        repo.save(log);
        return lobbyClient.setVeterinario(idUser);
    }


    //catalogo
    public MedicamentoDTO updateMedicamento(MedicamentoDTO medicamento,Integer idAdmin){
        Log log=new Log();
        log.setAdminId(idAdmin);
        log.setMensaje("Se han realizado cambios en el medicamento: "+medicamento.getId());
        log.setRuta("updateMed");
        return catalogoClient.updateMedicamento(medicamento);
    }
    public ServicioDTO updateServicios(ServicioDTO servicioDTO, Integer idAdmin){
        Log log=new Log();
        log.setAdminId(idAdmin);
        log.setMensaje("Se han realizado cambios en el servicio: "+servicioDTO.getId());
        log.setRuta("updateServ");
        return catalogoClient.updateServicios(servicioDTO);
    }
    public MedicamentoDTO createMedicamento( MedicamentoDTO medCreateDTO, Integer idAdmin){
        MedicamentoDTO medicamentoDTO=catalogoClient.createMedicamento(medCreateDTO);
        Log log=new Log();
        log.setAdminId(idAdmin);
        log.setMensaje("Se ha agregado el medicamento"+medicamentoDTO.getId());
        log.setRuta("createMed");
        return medicamentoDTO;
    }
    public ServicioDTO createServicio( ServicioDTO servCreateDTO, Integer idAdmin){
        ServicioDTO servicioDTO=catalogoClient.createServicio(servCreateDTO);
        Log log=new Log();
        log.setAdminId(idAdmin);
        log.setMensaje("Se ha agregado el servicio"+servicioDTO.getId());
        log.setRuta("createServ");
        return servicioDTO;
    }


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
