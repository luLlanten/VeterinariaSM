package com.veterinariasm.cliente_lobby.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veterinariasm.cliente_lobby.dto.AdminDTO;
import com.veterinariasm.cliente_lobby.dto.AdminRegistroDTO;
import com.veterinariasm.cliente_lobby.dto.UserDTO;
import com.veterinariasm.cliente_lobby.dto.UserRegistroDTO;
import com.veterinariasm.cliente_lobby.service.LobbyService;


@RestController 
@RequestMapping("/lobby") 
public class Controller {
    @Autowired
    private LobbyService service;

    @GetMapping 
    public ResponseEntity<Boolean> loginUser(@RequestBody UserDTO userDTO){
        try{
            if (service.loginUser(userDTO.getCorreo(), userDTO.getContrasena()))
                {
                    return ResponseEntity.ok(true);
                }else{
                    return ResponseEntity.ok(false);
                }
        }catch(Exception e){
            return ResponseEntity.badRequest().body(false);
        }
    }
    @GetMapping 
    public ResponseEntity<Boolean> loginAdmin(@RequestBody AdminDTO userDTO){
        try{
            if (service.loginUser(userDTO.getCorreo(), userDTO.getContrasena()))
                {
                    return ResponseEntity.ok(true);
                }else{
                    return ResponseEntity.ok(false);
                }
        }catch(Exception e){
            return ResponseEntity.badRequest().body(false);
        }
    }
    @PostMapping
    public ResponseEntity<Void> registroUser(Boolean v,@RequestBody UserRegistroDTO userDTO){
        //ver como comunicar el boolean desde el front hacia el metodo 
        try {
            service.crearUser(service.registroUser(v, userDTO.getCorreo(), userDTO.getContrasena()),userDTO.getNombre(),userDTO.getApellido(),userDTO.getDireccion(),userDTO.getTelefono());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping
    public ResponseEntity<Void> registroAdmin(Boolean v,@RequestBody AdminRegistroDTO userDTO){
        //ver como comunicar el boolean desde el front hacia el metodo 
        try {
            service.crearAdmin(service.registroAdmin(v, userDTO.getCorreo(), userDTO.getContrasena()),userDTO.getNombre(),userDTO.getApellido(),userDTO.getTelefono());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
