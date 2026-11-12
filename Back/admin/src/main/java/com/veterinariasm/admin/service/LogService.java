package com.veterinariasm.admin.service;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinariasm.admin.client.CitaClient;
import com.veterinariasm.admin.client.CompraClient;
import com.veterinariasm.admin.client.LobbyClient;
import com.veterinariasm.admin.dto.AdminDTO;
import com.veterinariasm.admin.dto.UserDTO;
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

    //añadir resto de clients

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

    

}
