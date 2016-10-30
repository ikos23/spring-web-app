package com.ivk23.lms;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ivk23.lms.dao.repository.EmployeeRepository;

@SpringBootApplication
public class App {
	
	// TEST THIS MODULE AS A COMPLETELY SEPARATE UNIT
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(EmployeeRepository repository) {
		return (args) -> {
			System.out.println("**************************************************************");
			repository.findAll().forEach(System.out::println);
			System.out.println("**************************************************************");
		};
	}
	
}
