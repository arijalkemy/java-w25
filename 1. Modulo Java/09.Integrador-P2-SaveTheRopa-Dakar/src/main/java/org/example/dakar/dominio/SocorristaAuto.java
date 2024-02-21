package org.example.dakar.dominio;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level= AccessLevel.PRIVATE)
public class SocorristaAuto extends VehiculoSocorrista{

    public void socorrer(Auto unAuto){
        System.out.println("Socorriendo auto " + unAuto.getPatente());
    }
}
