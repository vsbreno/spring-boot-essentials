package br.com.vsbreno.spring_boot_essentials;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.vsbreno.spring_boot_essentials.database.model.ProductEntity;

@SpringBootApplication
public class SpringBootEssentialsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEssentialsApplication.class, args);
		
	}

}
