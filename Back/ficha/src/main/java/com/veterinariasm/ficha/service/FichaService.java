package com.veterinariasm.ficha.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.veterinariasm.ficha.client.UsuarioClient;
import com.veterinariasm.ficha.dto.FichaDTO;
import com.veterinariasm.ficha.dto.MascotaDTO;
import com.veterinariasm.ficha.dto.UsuarioDTO;
import com.veterinariasm.ficha.model.Ficha;
import com.veterinariasm.ficha.model.Mascota;
import com.veterinariasm.ficha.model.Necropsia;
import com.veterinariasm.ficha.repo.FichaRepo;
import com.veterinariasm.ficha.repo.MascotaRepo;
import com.veterinariasm.ficha.repo.NecropsiaRepo;

import io.swagger.v3.oas.annotations.media.Schema;

@Service 
public class FichaService {

    private FichaRepo fichaRepo;

    private  MascotaRepo mascotaRepo;

    private  NecropsiaRepo necropsiaRepo;

    private UsuarioClient usuarioClient;


    @Schema (description = "metodo para crear la ficha")
    public Boolean crearFicha(FichaDTO ficha){
        try{
            Ficha nuevo = new Ficha();
            UsuarioDTO usuario= usuarioClient.findUsuarioDTOById(ficha.getUsuarioDTO());
            if(!usuario.equals(null)){
                nuevo.setFecha_ficha(new Date());
                nuevo.setAntecedentes(ficha.getAntecedentes());
                nuevo.setIdUsuario(usuario.getId());
                nuevo.setIdMascota(ficha.getMascotaDTO());
                fichaRepo.save(nuevo);
                return true;
            }else{
                return false;
            }
        }catch (Exception e) {
            return false;
        }
    }

    @Schema (description = "metodo para crear una mascota")
    public Mascota crearMascota(MascotaDTO mascota, Boolean fichaCreada){
        Mascota nuevo = new Mascota();
        nuevo.setNombre(mascota.getNombre());
        nuevo.setEspecie(mascota.getEspecie());
        nuevo.setPeso(mascota.getPeso());
        nuevo.setTamanio(mascota.getTamaño());
        nuevo.setFecha_ingreso(new Date());
        nuevo.setFecha_alta(null);
        nuevo.setSexo(nuevo.getSexo());
        nuevo.setRaza(mascota.getRaza());
        nuevo.setActivo(mascota.getActivo());
        nuevo.setChip(mascota.getChip());
        nuevo.setIdUsuario(null);
        return mascotaRepo.save(nuevo);
    }

    @Schema (description = "metodo para crear la necropsia")
    public Necropsia crearNecropsia (Necropsia necropsia){
        Necropsia nuevo = new Necropsia();
        nuevo.setFecha(new Date());
        nuevo.setCondicion_corporal_visual(necropsia.getCondicion_corporal_visual());
        nuevo.setGrado_de_descomposicion(necropsia.getGrado_de_descomposicion());
        nuevo.setExamen(necropsia.getExamen());
        nuevo.setMuestra_remitidas(necropsia.getMuestra_remitidas());
        nuevo.setIdUsuario(necropsia.getIdUsuario());
        nuevo.setIdMascota(necropsia.getIdMascota());
        return necropsiaRepo.save(nuevo);
    }

    @Schema (description = "metodo para ingresar la fecha de alta de la mascota")
    public Mascota darAlta(Integer id){
        Mascota mascota = mascotaRepo.findById(id).get();
        mascota.setFecha_alta(new Date());
        return mascotaRepo.save(mascota);
    }

    @Schema (description = "metodo para buscar la mascota por el id del usuario")
    public List<Mascota> buscarMascotaPorUsuario(Integer id){
        return mascotaRepo.findByIdUsuario(id);
    }

    @Schema (description = "metodo para buscar ficha por el id del usuario")
    public List<Ficha> buscarFichaPorUsuario(Integer id){
        return fichaRepo.findByIdUsuario(id);
    }

    @Schema (description = "metodo para buscar necropsia por el id de la mascota")
    public Necropsia buscarNecropsiaPorIdMascota(Integer id){
        return necropsiaRepo.findByIdMascota(id);
    }

    @Schema (description = "metodo para buscar necropsia por el id del usuario")
    public List<Necropsia> buscarNecropsiaPorIdUsuario(Integer id){
        return necropsiaRepo.findByIdUsuario(id);
    }

    @Schema (description = "metodo para modificar a la mascota")
    public Mascota modificarMascota(Mascota mascota){
        Mascota mascotaVieja = mascotaRepo.findById(mascota.getId()).get();
        mascotaVieja.setActivo(mascota.getActivo());
        mascotaVieja.setPeso(mascota.getPeso());
        mascotaVieja.setTamanio(mascota.getTamanio());
        return mascotaRepo.save(mascotaVieja);
    }


    @Schema (description = "metodo para desactivar a una mascota")
    public void desactivarMascota(Integer id){
        Mascota mascota = mascotaRepo.findById(id).get();
        mascota.setActivo(false);
    }

    @Schema (description = "metodo para buscar mascota por el id")
    public Mascota buscarMascotaPorId(Integer id){
        return mascotaRepo.findById(id).get();
    }

    @Schema (description = "metodo para buscar ficha por id")
    public Ficha buscarFichaPorId(Integer id){
        return fichaRepo.findById(id).get();
    }

    @Schema (description = "metodo para buscar necropsia por id")
    public Necropsia buscarNecropsiaPorId(Integer id){
        return necropsiaRepo.findById(id).get();
    }

    @Schema (description = "metodo para buscar a todas las mascotas")
    public List<Mascota> todasLasMascotas(){
        return mascotaRepo.findAll();
    }

    @Schema (description = "metodo para buscar todas las fichas")
    public List<Ficha> todasLasFichas(){
        return fichaRepo.findAll();
    }

    @Schema (description = "metodo para buscar todas las necropsias")
    public List<Necropsia> todasLasNecropsias(){
        return necropsiaRepo.findAll();
    }
}
