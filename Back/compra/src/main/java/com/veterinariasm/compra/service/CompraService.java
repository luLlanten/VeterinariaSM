package com.veterinariasm.compra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinariasm.compra.client.CatalogoClient;
import com.veterinariasm.compra.client.UsuarioClient;
import com.veterinariasm.compra.dto.UsuarioDTO;
import com.veterinariasm.compra.model.Carrito;
import com.veterinariasm.compra.model.MedCarrito;
import com.veterinariasm.compra.model.SerCarrito;
import com.veterinariasm.compra.repo.BoletaRepo;
import com.veterinariasm.compra.repo.CarritoRepo;
import com.veterinariasm.compra.repo.MedCarritoRepo;
import com.veterinariasm.compra.repo.SerCarritoRepo;

@Service 
public class CompraService {
    @Autowired 
    private BoletaRepo boletaRepo;
    
    @Autowired 
    private CarritoRepo carritoRepo;
    
    @Autowired 
    private MedCarritoRepo medCarritoRepo;
    
    @Autowired 
    private SerCarritoRepo serCarritoRepo;

    @Autowired 
    private CatalogoClient catalogoClient;
    
    @Autowired 
    private UsuarioClient usuarioClient;

    public Carrito crearCarrito(Integer id){
        UsuarioDTO usuarioDTO=usuarioClient.finUsuarioDTO(id);
        if(usuarioDTO.equals(null)){
        Carrito carrito=new Carrito();
        carrito.setCantidad(0);
        carrito.setUsuarioId(usuarioDTO.getId());
        return carrito;
        }else{
            return null;
        }
    }

}
