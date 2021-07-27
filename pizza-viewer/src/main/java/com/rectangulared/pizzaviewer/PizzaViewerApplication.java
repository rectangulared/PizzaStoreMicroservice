package com.rectangulared.pizzaviewer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;

@SpringBootApplication
@EntityScan(basePackages = "com.rectangulared.common")
@EnableJpaRepositories(basePackages = "com.rectangulared.common")
public class PizzaViewerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaViewerApplication.class, args);
	}

}
