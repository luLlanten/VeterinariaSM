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

@Service 
public class FichaService {

    private FichaRepo fichaRepo;

    private  MascotaRepo mascotaRepo;

    private  NecropsiaRepo necropsiaRepo;

    private UsuarioClient usuarioClient;


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

    public Mascota darAlta(Integer id){
        Mascota mascota = mascotaRepo.findById(id).get();
        mascota.setFecha_alta(new Date());
        return mascotaRepo.save(mascota);
    }

    public List<Mascota> buscarMascotaPorId(Integer id){
        return mascotaRepo.findByIdUsuario(id);
    }

    public List<Ficha> buscarFichaPorId(Integer id){
        return fichaRepo.findByIdUsuario(id);
    }

    public Necropsia buscarNecropsiaPorIdMascota(Integer id){
        return necropsiaRepo.findByIdMascota(id);
    }

    public List<Necropsia> buscarNecropsiaPorIdUsuario(Integer id){
        return necropsiaRepo.findByIdUsuario(id);
    }

    public Mascota modificarMascota(Mascota mascota){
        Mascota mascotaVieja = mascotaRepo.findById(mascota.getId()).get();
        mascotaVieja.setActivo(mascota.getActivo());
        mascotaVieja.setPeso(mascota.getPeso());
        mascotaVieja.setTamanio(mascota.getTamanio());
        return mascotaRepo.save(mascotaVieja);
    }


    public void desactivarMascota(Integer id){
        Mascota mascota = mascotaRepo.findById(id).get();
        mascota.setActivo(false);
    }



}
