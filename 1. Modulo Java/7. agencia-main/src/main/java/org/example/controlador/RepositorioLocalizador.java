package org.example.controlador;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.example.modelo.Localizador;

import java.util.ArrayList;
import java.util.List;


@Data
@FieldDefaults(level= AccessLevel.PRIVATE)
public class RepositorioLocalizador {
    List<Localizador> localizadores = new ArrayList<>();

    public void agregarLocalizador(Localizador localizador){
        this.localizadores.add(localizador);
    }

    public double totalVentas(){
        return this.localizadores.stream().mapToDouble(loc -> loc.getTotal()).sum();
    }

    public int totalLocalizadoresVendidos(){
        return this.localizadores.size();
    }

    public double promedioVentas(){
        return this.localizadores.stream().mapToDouble(loc -> loc.getTotal()).average().orElse(0);
    }

    public double totalReservas(){
        return this.localizadores.stream()
                                .mapToDouble(loc -> (loc.getReservas().stream()
                                                                        .mapToDouble(res -> res.getCantidad()).sum())
                                ).sum();
    }

}
