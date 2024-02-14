package org.clase06_02_24.ejercicio_guardarropa;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class Prenda {
    String marca;
    String modelo;



    @Override
    public String toString(){
        return "Marca: " + marca + ", Modelo: " + modelo;
    }

}