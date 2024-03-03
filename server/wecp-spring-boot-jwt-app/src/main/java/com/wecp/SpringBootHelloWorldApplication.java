package com.wecp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wecp.entities.User;
import com.wecp.repos.UserRepository;
import com.wecp.service.UserService;

@SpringBootApplication
public class SpringBootHelloWorldApplication implements CommandLineRunner{
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHelloWorldApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		User admin = new User();
		admin.setName("admin");
		admin.setEmail("admin@admin.com");
		admin.setPhone("9876543210");
		admin.setPassword("12345");
		admin.setRole("ADMIN");

		userService.addUser(admin);
	}
}