package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona();
        Persona p2 = new Persona("Nico", 24, "23424141");
        Persona p3 = new Persona("Dani", 23, "12313131", 85.7, 1.9);
        int imc = p3.calcularIMC();
        System.out.println(p3.toString());
        System.out.println("Calculando IMC");
        if(imc == -1){
        System.out.println("Bajo de peso");}
        else {
            if(imc == 0){
                System.out.println("Peso saludable");
            }
            else{
                System.out.println("Sobrepeso");
            }
        }
        boolean mayor = p3.esMayorDeEdad();
        if (mayor) {
            System.out.println("Es mayor de edad");
        }else{
            System.out.println("Es menor de edad");
        }


    }
}