package com.veterinariasm.cliente_lobby.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veterinariasm.cliente_lobby.dto.AdminDTO;
import com.veterinariasm.cliente_lobby.dto.AdminRegistroDTO;
import com.veterinariasm.cliente_lobby.dto.UserDTO;
import com.veterinariasm.cliente_lobby.dto.UserRegistroDTO;
import com.veterinariasm.cliente_lobby.model.Admin;
import com.veterinariasm.cliente_lobby.model.User;
import com.veterinariasm.cliente_lobby.service.LobbyService;


@RestController 
@RequestMapping("/lobby") 
public class Controller {
    @Autowired
    private LobbyService service;

    @GetMapping ("/login")
    public ResponseEntity<Boolean> loginUser(@RequestBody UserDTO userDTO){
        try{
            if (service.loginUser(userDTO))
                {
                    return ResponseEntity.ok(true);
                }else{
                    return ResponseEntity.ok(false);
                }
        }catch(Exception e){
            return ResponseEntity.badRequest().body(false);
        }
    }
    @GetMapping ("/login/admin")
    public ResponseEntity<Boolean> loginAdmin(@RequestBody AdminDTO userDTO){
        try{
            if (service.loginAdmin(userDTO))
                {
                    return ResponseEntity.ok(true);
                }else{
                    return ResponseEntity.ok(false);
                }
        }catch(Exception e){
            return ResponseEntity.badRequest().body(false);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<Void> registroUser(Boolean v,@RequestBody UserRegistroDTO userDTO){
        //ver como comunicar el boolean desde el front hacia el metodo 
        try {
            service.crearUser(service.registroUser(v, userDTO.getCorreo(), userDTO.getContrasena()),userDTO.getNombre(),userDTO.getApellido(),userDTO.getDireccion(),userDTO.getTelefono());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/login/admin")
    public ResponseEntity<Void> registroAdmin(Boolean v,@RequestBody AdminRegistroDTO userDTO){
        //ver como comunicar el boolean desde el front hacia el metodo 
        try {
            service.crearAdmin(service.registroAdmin(v, userDTO.getCorreo(), userDTO.getContrasena()),userDTO.getNombre(),userDTO.getApellido(),userDTO.getTelefono());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    //estos dos gets seriviran con los demas microservicios
    @GetMapping ("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id){
        try {
            User user=service.buscarUser(id).get();
            if(user.equals(null)){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(user);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping ("/admin/{id}")
    public ResponseEntity<Admin> getAdmin(@PathVariable Integer id){
        try {
            Admin user=service.buscarAdmin(id).get();
            if(user.equals(null)){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(user);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping ("/update/user")
    public ResponseEntity<Void> updateUser(@RequestBody User user){
        try {
            service.updateUser(user);
            return ResponseEntity.accepted().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping ("/update/admin")
    public ResponseEntity<Void> updateAdmin(@RequestBody Admin user){
        try {
            service.updateAdmin(user);
            return ResponseEntity.accepted().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping ("/update/user")
    public ResponseEntity<Void> deleteUser(@RequestBody UserDTO user){
        try {
            service.deleteUser(user);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping ("/update/admin")
    public ResponseEntity<Void> deleteAdmin(@RequestBody AdminDTO user){
        try {
            service.deleteAdmin(user);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping ("/users")
    public ResponseEntity<List<User>> listUsers(){
        try {
            return ResponseEntity.ok(service.todosLosUsers());
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }
    @GetMapping ("/admins")
    public ResponseEntity<List<Admin>> listAdmins(){
        try {
            return ResponseEntity.ok(service.todosLosAdmins());
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }
    


}
