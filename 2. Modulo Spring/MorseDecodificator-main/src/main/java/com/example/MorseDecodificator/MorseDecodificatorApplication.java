package com.example.MorseDecodificator;

import com.example.MorseDecodificator.controller.Codificator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

@SpringBootApplication
public class MorseDecodificatorApplication {
	public static void main(String[] args) {
		System.out.println("morse");
		SpringApplication.run(MorseDecodificatorApplication.class, args);
	}


}
