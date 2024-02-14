package org.example.dakar.dominio;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level= AccessLevel.PRIVATE)
public class SocorristaMoto extends VehiculoSocorrista{

    public void socorrer(Moto moto){
        System.out.println("Socorriendo moto " + moto.getPatente());
    }
}
