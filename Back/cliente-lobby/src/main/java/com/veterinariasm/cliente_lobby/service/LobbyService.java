package com.veterinariasm.cliente_lobby.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.veterinariasm.cliente_lobby.dto.AdminDTO;
import com.veterinariasm.cliente_lobby.dto.UserDTO;
import com.veterinariasm.cliente_lobby.model.Admin;
import com.veterinariasm.cliente_lobby.model.User;
import com.veterinariasm.cliente_lobby.repo.AdminRepo;
import com.veterinariasm.cliente_lobby.repo.UserRepo;

import io.swagger.v3.oas.annotations.media.Schema;

@Service 
public class LobbyService {
    
    @Autowired 
    private AdminRepo repoAdmin;

    @Autowired 
    private UserRepo repoUser;

    @Autowired 
    private PasswordEncoder passwordEncoder;


    @Schema (description = "el metodo loginUser se encarga de que el usuario inicie sesion")
    public Boolean loginUser(UserDTO userDTO){
        //primero buscara el correo, luego confirmara si la contraseña corresponde con la del usuario del correo
        Optional<User> user = Optional.of(repoUser.findByCorreo(userDTO.getCorreo()));
        if (user.isPresent()){
            if(user.get().getContrasena().equals(passwordEncoder.encode(userDTO.getContrasena()))&& user.get().getActivo()){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        } 
    }

    @Schema (description = "el metodo loginAdmin se encarga de que el Admin inicie sesion")
    public Boolean loginAdmin(AdminDTO adminDTO){
        //primero buscara el correo, luego confirmara si la contraseña corresponde con la del usuario admin del correo
        Optional<Admin> user = Optional.of(repoAdmin.findByCorreo(adminDTO.getCorreo()));
        if (user.isPresent()){
            if(user.get().getContrasena().equals(passwordEncoder.encode(adminDTO.getContrasena()))&& user.get().getActivo()){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        } 
    }

    @Schema (description = "el metodo registroUser se encargara de que el user pueda registrarse")
    public UserDTO registroUser(Boolean valido, String correo,String contrasena){
        //primer paso a creacion de una cuenta, dependera de las validaciones del front 
        if (valido){
            UserDTO userDTO= new UserDTO(correo,contrasena);
            return userDTO;
        }else{
            return null;
        }
    } 

    @Schema (description = "el metodo crearUser se encarga del ingreso de datos del usuario despues del registro")
    public User crearUser(UserDTO userDTO,String numbre,String apellido, String direccion,Integer telefono){
        if(!userDTO.equals(null)){
            User usuarioNuevo=new User();
            String contraEncriptada= passwordEncoder.encode(userDTO.getContrasena());
            usuarioNuevo.setNombre(numbre);
            usuarioNuevo.setApellido(apellido);
            usuarioNuevo.setFechaIngreso(new Date());
            usuarioNuevo.setCorreo(userDTO.getCorreo());
            usuarioNuevo.setContrasena(contraEncriptada);
            usuarioNuevo.setDireccion(direccion);
            usuarioNuevo.setTelefono(telefono);
            usuarioNuevo.setTipo(false);
            usuarioNuevo.setActivo(true);
            repoUser.save(usuarioNuevo);
            return usuarioNuevo;}
        else{
            return null;
        }
    }//el tipo de useuario se setea aparte, por default sera false(cliente) 
    @Schema (description = "el metodo registroAdmin se encargara de que el Admin pueda registrarse")
    public AdminDTO registroAdmin(Boolean valido, String correo,String contrasena){
        if (valido){
            AdminDTO userDTO= new AdminDTO(correo,contrasena);
            return userDTO;
        }else{
            return null;
        }
    }

    //lo dejare igual que el user por ahora, pero yo creo que faltaria añadir algo mas para validar un admin
    @Schema (description = "el metodo crearAdmin se encarga del ingreso de datos del Admin despues del registro")
    public Admin crearAdmin(AdminDTO adminDTO,String nombre,String apellido,Integer telefono){
        if(adminDTO.equals(null)){
            Admin adminNuevo=new Admin();
            String contraEncriptada= passwordEncoder.encode(adminDTO.getContrasena());
            adminNuevo.setCorreo(adminDTO.getCorreo());
            adminNuevo.setContrasena(contraEncriptada);
            adminNuevo.setNombre(nombre);
            adminNuevo.setFechaIngreso(new Date());
            adminNuevo.setApellido(apellido);
            adminNuevo.setTelefono(telefono);
            adminNuevo.setActivo(true);
            repoAdmin.save(adminNuevo);
            return adminNuevo;
        }else{
            return null;
        }
    }

    @Schema (description = "el metodo deleteUser se encargara de que el user pueda desactivarse")
    public void deleteUser(UserDTO userDTO){
        //aca no uso optional porque en teoria el usuario ya inicio sesion, es decir, no se encontrara con un usuario nulo
        User user=repoUser.findByCorreo(userDTO.getCorreo());
        user.setActivo(false);
        repoUser.save(user);
    }//como tal no se borra el usuario, solo se desactiva

    @Schema (description = "el metodo deleteAdmin se encargara de que el Admin pueda desactivarse")
    public void deleteAdmin(AdminDTO userDTO){
        //igual que en delete user pero en admin
        Admin user=repoAdmin.findByCorreo(userDTO.getCorreo());
        user.setActivo(false);
        repoAdmin.save(user);
    }

    @Schema (description = "el metodo updateUser se encargara de que el user pueda modificarse(solo el id,correo y contraseña no son modificables)")
    public void updateUser(User user){
        //el id,correo ni contraseña deberian cambiar, en el front se debe mostrar que cambios se permiten
        User userViejo=repoUser.findById(user.getId()).get();
        userViejo.setApellido(user.getApellido());
        userViejo.setNombre(user.getNombre());
        userViejo.setDireccion(user.getDireccion());
        userViejo.setTelefono(user.getTelefono());
        repoUser.save(userViejo);
    }//la contraseña se cambiara en otro metodo (recuperar cuenta)

    @Schema (description = "el metodo updateAdmin se encargara de que el Admin pueda modificarse(solo el id,correo y contraseña no son modificables)")
    public void updateAdmin(Admin user){
        //igual que en user
        Admin userViejo=repoAdmin.findById(user.getId()).get();
        userViejo.setApellido(user.getApellido());
        userViejo.setNombre(user.getNombre());
        userViejo.setTelefono(user.getTelefono());
        repoAdmin.save(userViejo);
    }

    //agregar recuperar cuenta

    //metodos generales, serviran en los otros ms 

    @Schema (description = "el metodo buscarUser se encarga de buscar el user a traves del id")
    public Optional<User> buscarUser(Integer id){
        return repoUser.findById(id);
    }

    @Schema (description = "el metodo buscarAdmin se encarga de buscar el Admin a traves del id")
    public Optional<Admin> buscarAdmin(Integer id){
        return repoAdmin.findById(id);
    }

    @Schema (description = "el metodo buscarUserPorCorreo se encarga de buscar el user a traves del correo")
    public Optional<User> buscarUserPorCorreo(String correo){
        return Optional.of(repoUser.findByCorreo(correo));
    }

    @Schema (description = "el metodo buscarAdminPorCorreo se encarga de buscar el Admin a traves del correo")
    public Optional<Admin> buscarAdminPorCorreo(String correo){
        return Optional.of(repoAdmin.findByCorreo(correo));
    }

    @Schema (description = "el metodo todosLosUsers se encarga de mostrar todos los users para vista de admin")
    public List<User> todosLosUsers(){
        return repoUser.findAll();
    }

    @Schema (description = "el metodo todosLosAdmins se encarga de mostrar todos los admin para vista de admin")
    public List<Admin> todosLosAdmins(){
        return repoAdmin.findAll();
    }
    public User setearVeterinario(Integer id){
        User user=repoUser.findById(id).get();
        if(!user.equals(null)){
            user.setTipo(true);
            return repoUser.save(user);
        }else{
            return null;
        }
    }

}
