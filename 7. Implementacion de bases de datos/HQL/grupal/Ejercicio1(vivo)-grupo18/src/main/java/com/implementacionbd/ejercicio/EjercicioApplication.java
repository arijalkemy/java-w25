package com.implementacionbd.ejercicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EjercicioApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjercicioApplication.class, args);
	}
/**
 De las clases mencionadas, se sabe que un vehículo puede denunciar múltiples siniestros y
 un siniestro pertenece a un solo vehículo.


 Se debe:

 Crear la aplicación utilizando la separación de capas adecuada.
 Crear los endpoints necesarios para crear y consultar los vehículos y siniestros denunciados.
 Utilizando consultas HQL, se pide:
 Listar las patentes de todos los vehículos registrados.
 Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
 Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el corriente año.
 Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos.
 Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos.
 Almacenar el resultado de la consulta en una lista de listas de dos elementos; el primero será un Vehículo y el segundo un Integer. Habrá que crear la clase VehiculoSiniestro con su correspondiente constructor.
 */
}
