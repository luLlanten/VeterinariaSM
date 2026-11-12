package com.veterinariasm.ficha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients 
@SpringBootApplication
public class FichaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FichaApplication.class, args);
	}

}
