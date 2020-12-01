package com.kumasi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="FilmRepository")
public class GadgetApplication {

	public static void main(String[] args) {
		SpringApplication.run(GadgetApplication.class, args);
	}

}
