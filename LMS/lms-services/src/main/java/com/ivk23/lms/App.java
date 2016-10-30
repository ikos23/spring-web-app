package com.ivk23.lms;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ivk23.lms.service.EmployeeService;
import com.ivk23.lms.service.ReferenceDataService;

@SpringBootApplication
public class App {

	// TEST THIS MODULE AS A COMPLETELY SEPARATE UNIT
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public CommandLineRunner demo(EmployeeService service, ReferenceDataService refData) {

		return (args) -> {
			System.out.println("**************************************************************");
			service.findAllEmployees().forEach(System.out::println);
			System.out.println("**************************************************************");
			refData.getAllRoles().forEach(System.out::println);
			System.out.println("**************************************************************");
		};

	}
}
