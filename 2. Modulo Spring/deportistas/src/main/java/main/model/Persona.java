package main.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.management.ConstructorParameters;
import java.beans.ConstructorProperties;

@AllArgsConstructor
@Getter
@Setter
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
}
