package com.main;

public class Main {

    public static void main(String[] args) {
		 Persona persona1 = new Persona();
		 Persona persona2 = new Persona("Sofia",20,"45463728");
		 Persona persona3 = new Persona("Sara",18,"283746294",61.4,1.60);
		 Persona persona4 = new Persona("Elisa",23);

		 System.out.println("Persona 1: "+persona1);
		 System.out.println("Persona 2: "+persona2);
		 System.out.println("Persona 3: "+persona3);
		 System.out.println("Persona 4: "+persona4);

		 System.out.println("INDICE DE MASA CORPORAL");
		 double indice= persona3.calcularIMC();
		 if (indice==-1){
			 System.out.println("Bajo de peso");
		 }else{
			if (indice==0){
				System.out.println("Peso saludable");
			}else{
				if(indice==1){
					System.out.println("Sobre peso");
				}else{
					System.out.println("La altura no puede ser igual o menor a cero");
				}
			 }
		 }
		System.out.println("MAYOR DE EDAD");
		boolean mayorEdad= persona3.esMayorDeEdad();
		if (mayorEdad==true){
			System.out.println("La persona es mayor de edad");
		}else{
			System.out.println("La persona NO es mayor de edad");
		}
    }
}
