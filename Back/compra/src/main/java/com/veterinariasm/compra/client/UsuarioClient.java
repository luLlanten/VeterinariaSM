package com.veterinariasm.compra.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient (name = "cliente-lobby")
public interface UsuarioClient {

}
