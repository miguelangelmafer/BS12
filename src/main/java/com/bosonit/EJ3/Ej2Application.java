package com.bosonit.EJ3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients //informamos a Spring que vamos a usar Feign
public class Ej2Application {

	public static void main(String[] args) {
		SpringApplication.run(Ej2Application.class, args);
	}

}


