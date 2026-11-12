package com.veterinariasm.admin.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.veterinariasm.admin.dto.BoletaDTO;
import com.veterinariasm.admin.dto.CarritoDTO;

@FeignClient(name = "compra") 
public interface CompraClient {
    @GetMapping ("/admin/boletas")
    List<BoletaDTO> getAllBoletas();

    @GetMapping ("/admin/carritos")
    List<CarritoDTO> getAllCarritos();

    @GetMapping ("/admin/boletas/{id}")
    BoletaDTO getBoleta(@PathVariable Integer id);

    @GetMapping ("/admin/boletas/carrito")
    List<BoletaDTO> getBoletasByCarrito(@RequestBody CarritoDTO carrito);

    @GetMapping ("/admin/carrito/{id}")
    CarritoDTO getCarritoById(@PathVariable Integer id);

    @GetMapping ("/admin/carrito/user/{id}")
    CarritoDTO getCarritoByUser(@PathVariable Integer id );
}
