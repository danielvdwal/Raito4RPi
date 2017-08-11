package io.reflectoring.raito4rpi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Raito4RPiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Raito4RPiApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext applicationContext) {
		return args -> {
			System.out.println("Konnichiwa sekai (Hello World)!");
		};
	}

}
