package com.packt.cardatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.apple.eawt.Application;
import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.domain.User;
import com.packt.cardatabase.repository.CarRepository;
import com.packt.cardatabase.repository.OwnerRepository;
import com.packt.cardatabase.repository.UserRepository;

@SpringBootApplication
public class CardatabaseApplication extends SpringBootServletInitializer {
	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);
	
	@Autowired
	private CarRepository repository;
	@Autowired
	private OwnerRepository orepository;
	@Autowired
	private UserRepository urepository;
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("Hello Spring Boot");
	}
	@Bean
	CommandLineRunner runner(){
	return args -> {
		// Add owner objects and save these to db
		Owner owner1 = new Owner("John" , "Johnson");
		Owner owner2 = new Owner("Mary" , "Robinson");
		orepository.save(owner1);
		orepository.save(owner2);

		// Add car object with link to owners and save these to db.
		Car car = new Car("Ford", "Mustang", "Red",
		"ADF-1121", 2017, 59000, owner1);
		repository.save(car);
		car = new Car("Nissan", "Leaf", "White",
		"SSJ-3002", 2014, 29000, owner2);
		repository.save(car);
		car = new Car("Toyota", "Prius", "Silver",
		"KKO-0212", 2018, 39000, owner2);
		repository.save(car);
		
		// username: user password: user
		urepository.save(new User("user",
		"$2a$10$/k3OLb2dsIhTPK8WTySBdepb/9Kx2Duu5l6RltDNPuzC/OvUmodQG",
		"USER"));
		// username: admin password: admin
		urepository.save(new User("admin",
		"$2a$10$7R0oLNlI44m2mW9WiNY6rebnzEdp0KeqsCZYfOLnzokMXJj1TA.iG",
		"ADMIN"));
	};
	}

}
