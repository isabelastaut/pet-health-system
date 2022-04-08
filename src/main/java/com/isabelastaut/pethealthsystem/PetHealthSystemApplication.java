package com.isabelastaut.pethealthsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.UUID;

@SpringBootApplication
public class PetHealthSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetHealthSystemApplication.class, args);
	}
}
