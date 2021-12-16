package com.catalogo.Catalogo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.catalogo.Catalogo.model"})
@ComponentScan(basePackages = {"com.catalogo.Catalogo"})
public class CatalogoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogoApplication.class, args);
	}

}
