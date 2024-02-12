package dakar;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class Carrera {
    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = new LinkedList<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public void darDeAltaAuto(Double velocidad, Double aceleracion, Integer anguloDeGiro, String patente) {
        if (vehiculos.size() < cantidadDeVehiculosPermitidos) {
            vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
        } else {
            System.out.println("Error: No se pudo agregar el auto. No hay más cupo en esta carrera.");
        }
    }

    public void darDeAltaMoto(Double velocidad, Double aceleracion, Integer anguloDeGiro, String patente) {
        if (vehiculos.size() < cantidadDeVehiculosPermitidos) {
            vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
        } else {
            System.out.println("Error: No se pudo agregar la moto. No hay más cupo en esta carrera.");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente) {
        vehiculos.removeIf(v -> v.getPatente().equals(patente));
    }

    public Vehiculo ganador() {
        //Velocidad * ½ Aceleracion / (AnguloDeGiro*(Peso-Cantidad de Ruedas * 100)
        Function<Vehiculo, Double> calc = v -> (v.getVelocidad() * 0.5 * v.getAceleracion()) / (v.getAnguloDeGiro() * (v.getPeso() - v.getRuedas() * 100));

        Vehiculo winner = vehiculos.stream()
                .max(Comparator.comparing(calc))
                .orElseThrow();

        return winner;
    }

    public void socorrerAuto(Auto auto) {
        socorristaAuto.socorrer(auto);
    }

    public void socorrerMoto(Moto moto) {
        socorristaMoto.socorrer(moto);
    }
}
