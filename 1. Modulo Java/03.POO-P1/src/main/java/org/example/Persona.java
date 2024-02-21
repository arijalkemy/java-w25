package org.example;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Persona {

     String nombre;
     int edad;
     String dni;
     double peso;
     private double altura;


    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }


    public int calcularIMC() {
        double imc = this.peso/Math.pow(this.altura, 2);
        return (imc < 20) ? -1 : (imc >= 20 && imc <= 25) ? 0 : 1;
    }

    public boolean esMayorDeEdad() {
        return this.edad >= 18;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre +
                "\nEdad: " + this.edad +
                "\nDNI: " + this.dni +
                "\nPeso: " + this.peso +
                "\nAltura: " + this.altura +
                "\n¿Es mayor de edad? " + (this.esMayorDeEdad() == true? "Sí": "No");
    }
}
