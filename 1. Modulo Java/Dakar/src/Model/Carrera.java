package Model;

import java.util.List;
import java.util.Optional;

public class Carrera {
    private int distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadVehiculosPermitidos;
    private List<Vehiculo> vehiculos;

    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(int distancia, double premioEnDolares, String nombre, int cantidadVehiculosPermitidos, List<Vehiculo> vehiculos,
                   SocorristaMoto socorristaMoto, SocorristaAuto socorristaAuto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        this.vehiculos = vehiculos;
        this.socorristaMoto = socorristaMoto;
        this.socorristaAuto = socorristaAuto;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        //Agrega un auto a la lista siempre q haya cupo
        if(vehiculos.size()< cantidadVehiculosPermitidos) vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
        else System.out.println("No hay cupo para agregar un nuevo vehiculo.");
    }
    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        //agrega una moto a la lista siempre q haya cupo
        if(vehiculos.size() < cantidadVehiculosPermitidos) vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
        else System.out.println("No hay cupo para agregar un nuevo vehiculo.");
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        vehiculos.remove(vehiculo);
        System.out.println("Vehiculo removido!");
    }
    public void eliminarVehiculoConPatente(String patente){
        Optional<Vehiculo> vehiculoAEliminar = vehiculos.stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(patente))
                .findFirst();
        if(vehiculoAEliminar.isPresent()) vehiculos.remove(vehiculoAEliminar.get());
        else System.out.println("El vehiculo que quiere eliminar no se encuentra registrado.");
    }

    public Vehiculo definirGanador(){
        double maximoValor = 0;
        Vehiculo ganador = vehiculos.get(0);
        for(Vehiculo vehiculo:
                vehiculos){
            double aux = (vehiculo.getVelocidad() * (0.5*vehiculo.getAceleracion()))
                    /(vehiculo.getAnguloDeGiro()*(vehiculo.getPeso()-(vehiculo.getRuedas()*100)));
            if(maximoValor<aux) {
                maximoValor = aux;
                ganador = vehiculo;
            }
        }
        return ganador;
    }

    public void socorrerAuto(String patente){
        Optional<Vehiculo> vehiculo = obtenerVehiculo(patente);
        if(vehiculo.isPresent() && vehiculo.get() instanceof Auto){
            socorristaAuto.socorrer((Auto) vehiculo.get());
        } else System.out.println("Este vehiculo no esta registrado o no es un auto.");
    }
    public void socorrerMoto(String patente){
        Optional<Vehiculo> vehiculo = obtenerVehiculo(patente);
        if(vehiculo.isPresent() && vehiculo.get() instanceof Moto){
            socorristaMoto.socorrer((Moto) vehiculo.get());
        } else System.out.println("Este vehiculo no esta registrado o no es una moto.");
    }

    private Optional<Vehiculo> obtenerVehiculo(String patente){
        return vehiculos.stream()
                .filter(vehi -> vehi.getPatente().equals(patente))
                .findFirst();
    }
}
