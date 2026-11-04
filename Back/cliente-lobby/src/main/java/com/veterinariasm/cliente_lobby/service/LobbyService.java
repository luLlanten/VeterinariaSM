package com.veterinariasm.cliente_lobby.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinariasm.cliente_lobby.dto.AdminDTO;
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

    public UserDTO registroUser(Boolean valido, String correo,String contrasena){
        //primer paso a creacion de una cuenta, dependera de las validaciones del front 
        if (valido){
            UserDTO userDTO= new UserDTO(correo,contrasena);
            return userDTO;
        }else{
            return null;
        }
    } 
    public User crearUser(UserDTO userDTO,String numbre,String apellido, String direccion,Integer telefono){
        if(userDTO.equals(null)){
            User usuarioNuevo=new User();
            usuarioNuevo.setNombre(numbre);
            usuarioNuevo.setApellido(apellido);
            usuarioNuevo.setFechaIngreso(new Date());
            usuarioNuevo.setCorreo(userDTO.getCorreo());
            usuarioNuevo.setContrasena(userDTO.getContrasena());
            usuarioNuevo.setDireccion(direccion);
            usuarioNuevo.setTelefono(telefono);
            usuarioNuevo.setTipo(false);
            repoUser.save(usuarioNuevo);
            return usuarioNuevo;}
        else{
            return null;
        }
    }//el tipo de useuario se setea aparte, por default sera false(cliente) 
    public AdminDTO registroAdmin(Boolean valido, String correo,String contrasena){
        if (valido){
            AdminDTO userDTO= new AdminDTO(correo,contrasena);
            return userDTO;
        }else{
            return null;
        }
    }//lo dejare igual que el user por ahora, pero yo creo que faltaria añadir algo mas para validar un admin
    public Admin crearAdmin(AdminDTO adminDTO,String nombre,String apellido,Integer telefono){
        if(adminDTO.equals(null)){
            Admin adminNuevo=new Admin();
            adminNuevo.setCorreo(adminDTO.getCorreo());
            adminNuevo.setContrasena(adminDTO.getContrasena());
            adminNuevo.setNombre(nombre);
            adminNuevo.setFechaIngreso(new Date());
            adminNuevo.setApellido(apellido);
            adminNuevo.setTelefono(telefono);
            repoAdmin.save(adminNuevo);
            return adminNuevo;
        }else{
            return null;
        }
    }
    //metodos generales, serviran en los otros ms 
    public Optional<User> buscarUser(Integer id){
        return Optional.of(repoUser.findById(id).get());
    }
    public Optional<Admin> buscarAdmin(Integer id){
        return Optional.of(repoAdmin.findById(id).get());
    }
    public Optional<User> buscarUserPorCorreo(String correo){
        return Optional.of(repoUser.findByCorreo(correo));
    }
    public Optional<Admin> buscarAdminPorCorreo(String correo){
        return Optional.of(repoAdmin.findByCorreo(correo));
    }
}
