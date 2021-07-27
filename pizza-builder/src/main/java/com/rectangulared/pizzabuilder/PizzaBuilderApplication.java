package com.rectangulared.pizzabuilder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.rectangulared.common")
@EnableJpaRepositories(basePackages = "com.rectangulared.common")
public class PizzaBuilderApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaBuilderApplication.class, args);
	}

}
