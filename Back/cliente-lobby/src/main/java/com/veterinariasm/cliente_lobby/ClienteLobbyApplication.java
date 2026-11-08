package com.veterinariasm.cliente_lobby;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients 
@SpringBootApplication
public class ClienteLobbyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClienteLobbyApplication.class, args);
	}

}
