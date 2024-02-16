package org.example.modelo;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class Cliente {
    String nombre;
    int futuroDescuento = 0;

    public Cliente (String nombre){
        this.nombre = nombre;
    }

    @Override
    public String toString(){
        return nombre;
    }

}
