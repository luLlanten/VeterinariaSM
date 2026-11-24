package com.veterinariasm.cliente_lobby.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
@CrossOrigin (origins="http://localhost:5173")
@Tag(name = "Usuarios y administradores", description = "Registro, inicio de sesión, perfil y recuperación de contraseña de clientes, veterinarios y administradores.")
public class Controller {
    @Autowired
    private LobbyService service;

    @Operation(summary = "Iniciar sesión (usuario)", description = "Valida correo y contraseña de un cliente o veterinario. Devuelve true si son correctas y la cuenta está activa; false en caso contrario.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    @PostMapping ("/login")
    public ResponseEntity<Boolean> loginUser(@RequestBody UserDTO userDTO){
        try{
            Boolean v=service.loginUser(userDTO);
            if (v)
                {
                    return ResponseEntity.ok(true);
                }else{
                    return ResponseEntity.ok(false);
                }
        }catch(Exception e){
            return ResponseEntity.badRequest().body(false);
        }
    }
    @Operation(summary = "Iniciar sesión (administrador)", description = "Valida correo y contraseña de un administrador. Devuelve true si son correctas y la cuenta está activa.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    @PostMapping ("/login/admin")
    public ResponseEntity<Boolean> loginAdmin(@RequestBody AdminDTO userDTO){
        try{
            Boolean v=service.loginAdmin(userDTO);
            if (v)
                {
                    return ResponseEntity.ok(true);
                }else{
                    return ResponseEntity.ok(false);
                }
        }catch(Exception e){
            return ResponseEntity.badRequest().body(false);
        }
    }
    @Operation(summary = "Registrar usuario", description = "Crea una cuenta de cliente. La contraseña se guarda encriptada con BCrypt. El parámetro v indica que el Front validó los datos.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    @PostMapping("/registro")
    public ResponseEntity<Void> registroUser(@Parameter(description = "true si el Front validó los datos del formulario") @RequestParam Boolean v,@RequestBody UserRegistroDTO userDTO){
        //ver como comunicar el boolean desde el front hacia el metodo 
        try {
            service.crearUser(service.registroUser(v, userDTO.getCorreo(), userDTO.getContrasena()),userDTO.getNombre(),userDTO.getApellido(),userDTO.getDireccion(),userDTO.getTelefono());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @Operation(summary = "Registrar administrador", description = "Crea una cuenta de administrador. La contraseña se guarda encriptada con BCrypt.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    @PostMapping("/registro/admin")
    public ResponseEntity<Void> registroAdmin(@Parameter(description = "true si el Front validó los datos del formulario") @RequestParam Boolean v,@RequestBody AdminRegistroDTO userDTO){
        //ver como comunicar el boolean desde el front hacia el metodo 
        try {
            service.crearAdmin(service.registroAdmin(v, userDTO.getCorreo(), userDTO.getContrasena()),userDTO.getNombre(),userDTO.getApellido(),userDTO.getTelefono());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    //estos dos gets seriviran con los demas microservicios
    @Operation(summary = "Obtener usuario por id", description = "Devuelve los datos de un usuario. Lo usan los otros microservicios.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @GetMapping ("/user/{id}")
    public ResponseEntity<User> getUser(@Parameter(description = "Id del usuario") @PathVariable Integer id){
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
    @Operation(summary = "Obtener administrador por id", description = "Devuelve los datos de un administrador.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @GetMapping ("/admin/{id}")
    public ResponseEntity<Admin> getAdmin(@Parameter(description = "Id del administrador") @PathVariable Integer id){
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

    @Operation(summary = "Actualizar usuario", description = "Modifica nombre, apellido, dirección y teléfono. El correo y la contraseña no se modifican.")
    @ApiResponses({
            @ApiResponse(responseCode = "202", description = "Solicitud aceptada"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    @PutMapping ("/update/user")
    public ResponseEntity<Void> updateUser(@RequestBody User user){
        try {
            service.updateUser(user);
            return ResponseEntity.accepted().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @Operation(summary = "Actualizar administrador", description = "Modifica nombre, apellido y teléfono del administrador.")
    @ApiResponses({
            @ApiResponse(responseCode = "202", description = "Solicitud aceptada"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    @PutMapping ("/update/admin")
    public ResponseEntity<Void> updateAdmin(@RequestBody Admin user){
        try {
            service.updateAdmin(user);
            return ResponseEntity.accepted().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Desactivar usuario", description = "No borra la cuenta: la marca como inactiva.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Sin contenido"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @DeleteMapping ("/update/user")
    public ResponseEntity<Void> deleteUser(@RequestBody UserDTO user){
        try {
            service.deleteUser(user);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @Operation(summary = "Desactivar administrador", description = "No borra la cuenta: la marca como inactiva.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Sin contenido"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @DeleteMapping ("/update/admin")
    public ResponseEntity<Void> deleteAdmin(@RequestBody AdminDTO user){
        try {
            service.deleteAdmin(user);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @Operation(summary = "Listar usuarios", description = "Devuelve todos los usuarios registrados.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "204", description = "Sin contenido")
    })
    @GetMapping ("/users")
    public ResponseEntity<List<User>> listUsers(){
        try {
            return ResponseEntity.ok(service.todosLosUsers());
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }
    @Operation(summary = "Listar administradores", description = "Devuelve todos los administradores registrados.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "204", description = "Sin contenido")
    })
    @GetMapping ("/admins")
    public ResponseEntity<List<Admin>> listAdmins(){
        try {
            return ResponseEntity.ok(service.todosLosAdmins());
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }
    @Operation(summary = "Asignar rol de veterinario", description = "Cambia el tipo del usuario a veterinario.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @PatchMapping ("/user/veterinario/{id}")
    public ResponseEntity<User> setVeterinario(@Parameter(description = "Id del usuario") @PathVariable Integer id){
        try {
            User user=service.setearVeterinario(id);
            if(user.equals(null)){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(user);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //recuperar
    @Operation(summary = "Recuperar contraseña (usuario)", description = "Define una nueva contraseña para el correo indicado. Se guarda encriptada.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Sin contenido"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @PatchMapping ("/recuperar/user")
    public ResponseEntity<Void> recuperarUser(UserDTO user){
        try {
            service.cambiarContraUser(user);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @Operation(summary = "Recuperar contraseña (administrador)", description = "Define una nueva contraseña para el correo del administrador. Se guarda encriptada.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Sin contenido"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @PatchMapping ("/recuperar/admin")
    public ResponseEntity<Void> recuperarAdmin(AdminDTO user){
        try {
            service.cambiarContraAdmin(user);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
