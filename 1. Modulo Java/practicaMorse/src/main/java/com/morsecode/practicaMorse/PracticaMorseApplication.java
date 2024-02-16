package com.morsecode.practicaMorse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
Se solicita llevar a cabo un API que reciba un Codigo Morse
y devuelva su traducción en español.
Tener como referencia del significado de cada símbolo la tabla:
*/

@SpringBootApplication
public class PracticaMorseApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticaMorseApplication.class, args);
	}

}

