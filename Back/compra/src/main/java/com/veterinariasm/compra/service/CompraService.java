package com.veterinariasm.compra.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.internal.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinariasm.compra.client.CatalogoClient;
import com.veterinariasm.compra.client.UsuarioClient;
import com.veterinariasm.compra.dto.MedicamentoDTO;
import com.veterinariasm.compra.dto.ProdCarritoDTO;
import com.veterinariasm.compra.dto.ServicioDTO;
import com.veterinariasm.compra.dto.UsuarioDTO;
import com.veterinariasm.compra.model.Boleta;
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
        if(!usuarioDTO.equals(null) && carritoRepo.findByUsuarioId(usuarioDTO.getId()).equals(null)){
        //busca que el usuario exista y que el carrito del usuario no
            Carrito carrito=new Carrito();
            carrito.setCantidad(0);
            carrito.setUsuarioId(usuarioDTO.getId());
            return carritoRepo.save(carrito);
        }else{
            return null;
        }
    }
    public void vaciarCarrito(Integer id){
        //Vacia el carrito despues de realizar una compra
        Carrito carrito=carritoRepo.findById(id).get();
        carrito.setCantidad(0);
        carrito.setTotal(0.0);
        //Mantiene los id del cliente y el propio
    }
    public void aniadirServicio(Integer idServ, Integer idCarrito){
        //desde servicio, se mandan los datos del servicio elegido a un sercarrito, el cual identifica al carrito 
        //luego, a medida que se crea un sercarrito, este suma los precios 
        ServicioDTO servicio = catalogoClient.findServicioDTO(idServ);
        Carrito carrito=carritoRepo.findById(idCarrito).get();
        SerCarrito serCarrito=new SerCarrito(servicio,carrito);
        serCarritoRepo.save(serCarrito);
        carrito.setCantidad(carrito.getCantidad()+1);
        carrito.setTotal(carrito.getTotal()+servicio.getPrecio());
    }
    public List<SerCarrito> verServiciosElegidos(Integer idCarrito){
        //muestra todos los servicios guareadados en el carrito
        Carrito carrito=carritoRepo.findById(idCarrito).get();
        List<SerCarrito> lista=serCarritoRepo.findByCarrito(carrito);
        return lista;
    }
    public void eliminarServicio(Integer idServicio,Integer idCarrito){
        //elimina los servicios del carrito individualmente (deberia ser a opcion del usuario)
        ServicioDTO servicio = catalogoClient.findServicioDTO(idServicio);
        Carrito carrito=carritoRepo.findById(idCarrito).get();
        SerCarrito serCarrito=new SerCarrito(servicio,carrito);
        serCarritoRepo.delete(serCarrito);
    }

    //igual que servicios, pero para medicamentos
    public void aniadirMedicamento(Integer idMed, Integer idCarrito){
        MedicamentoDTO med = catalogoClient.findMedicamentoDTO(idMed);
        Carrito carrito=carritoRepo.findById(idCarrito).get();
        MedCarrito medCarrito=new MedCarrito(med,carrito);
        medCarritoRepo.save(medCarrito);
        carrito.setCantidad(carrito.getCantidad()+1);
        carrito.setTotal(carrito.getTotal()+med.getPrecio());
    }
    public List<MedCarrito> verMedicamentosElegidos(Integer idCarrito){
        Carrito carrito=carritoRepo.findById(idCarrito).get();
        List<MedCarrito> lista=medCarritoRepo.findByCarrito(carrito);
        return lista;
    }
    public void eliminarMedicamento(Integer idMedicamento,Integer idCarrito){
        MedicamentoDTO medicamento = catalogoClient.findMedicamentoDTO(idMedicamento);
        Carrito carrito=carritoRepo.findById(idCarrito).get();
        MedCarrito medCarrito=new MedCarrito(medicamento,carrito);
        medCarritoRepo.delete(medCarrito);
    }

    public List<ProdCarritoDTO> comprar(Carrito carrito){
        //se llama al carrito y a los sercarrito y medcarritos que tengan los mismos id de usuario y carrito
        //aqui tambien se guarda la boleta
        Boleta boleta = new Boleta();
        boleta.setFecha(new Date());
        boleta.setCarrito(carrito);
        boletaRepo.save(boleta);
        List<ProdCarritoDTO> productos=new ArrayList<>();
        List<SerCarrito> listaServicios = serCarritoRepo.findByCarrito(carrito);
        List<MedCarrito> listaMedicamentos=medCarritoRepo.findByCarrito(carrito);
            if(!listaServicios.equals(null)){
                for (SerCarrito serCarrito:listaServicios){
                    ProdCarritoDTO producto=new ProdCarritoDTO(serCarrito,null);
                    productos.add(producto);
                }
            }
            if(!listaMedicamentos.equals(null)){
                for(MedCarrito medCarrito:listaMedicamentos){
                    ProdCarritoDTO producto=new ProdCarritoDTO(null, medCarrito);
                    productos.add(producto);
                }
            }
        return productos;
        //la lista de productos tiene por objetivo ser mostrada en la boleta visual del cliente, 
        //la boleta nuestra solo guardara el carrito, que ya guarda los demas datos
    }
}
