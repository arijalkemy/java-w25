package org.example.modelo;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class Cliente {
    String nombre;
    List<Localizador> localizadores;

    public Cliente (String nombre){
        this.nombre = nombre;
        this.localizadores = new ArrayList<>();
    }

    public void agregarLocalizador(Localizador localizador){
        this.localizadores.add(localizador);
    }

    @Override
    public String toString(){
        return nombre;
    }

}
