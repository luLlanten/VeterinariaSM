package com.veterinariasm.cliente_lobby.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinariasm.cliente_lobby.dto.UserDTO;
import com.veterinariasm.cliente_lobby.model.Admin;
import com.veterinariasm.cliente_lobby.model.User;
import com.veterinariasm.cliente_lobby.repo.AdminRepo;
import com.veterinariasm.cliente_lobby.repo.UserRepo;

@Service 
public class LobbyService {
    @Autowired 
    private AdminRepo repoAdmin;

    @Autowired 
    private UserRepo repoUser;

    public Boolean loginUser(String correo,String contrasena){
        //primero buscara el correo, luego confirmara si la contraseña corresponde con la del usuario del correo
        Optional<User> user = Optional.of(repoUser.findByCorreo(correo));
        if (user.isPresent()){
            if(user.get().getContrasena().equals(contrasena)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        } 
    }
    public Boolean loginAdmin(String correo,String contrasena){
        //primero buscara el correo, luego confirmara si la contraseña corresponde con la del usuario admin del correo
        Optional<Admin> user = Optional.of(repoAdmin.findByCorreo(correo));
        if (user.isPresent()){
            if(user.get().getContrasena().equals(contrasena)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        } 
    }

    public UserDTO registroUser(Boolean valido, String correo,String contrasena){//primer paso a creacion de una cuenta, dependera de las validaciones del front 
        if (valido){
            UserDTO userDTO= new UserDTO(correo,contrasena);
            return userDTO;
        }else{
            return null;
        }
    } 
    public User crearUser(UserDTO userDTO,String numbre,String apellido, String direccion,Integer telefono){
        User usuarioNuevo=new User();
        usuarioNuevo.setNombre(numbre);
        usuarioNuevo.setApellido(apellido);
        usuarioNuevo.setFechaIngreso(new Date());
        usuarioNuevo.setCorreo(userDTO.getCorreo());
        usuarioNuevo.setContrasena(userDTO.getContrasena());
        usuarioNuevo.setDireccion(direccion);
        usuarioNuevo.setTelefono(telefono);
        usuarioNuevo.setTipo(false);
        return usuarioNuevo;
    }//el tipo de useuario se setea aparte, por default sera false(cliente) 

}
