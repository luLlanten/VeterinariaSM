package com.veterinariasm.compra.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient (name = "catalogo")
public interface CatalogoClient { 

}
