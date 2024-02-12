package bootcamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class Carrera {

    private double distancia;
    private double premioEnDolares;
    private String nombre;
    int cantidadDeVehiculosPermitidos;
    List<Vehiculo> vehiculos;
    SocorristaAuto socorristaAuto;
    SocorristaMoto socorristaMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
        this.vehiculos = new ArrayList<>();
    }


    public void altaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void altaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculosConPatente(String patente){
        Optional<Vehiculo> v=vehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equals(patente)).findFirst();
        v.ifPresent(vehiculo -> vehiculos.remove(vehiculo));
    }

    public Vehiculo calcularGanador(){
        Double valorGanador = this.vehiculos.stream().mapToDouble(Vehiculo::calcularValor).max().getAsDouble();
        return this.vehiculos.stream().filter(vehiculo -> vehiculo.calcularValor() == valorGanador ).findAny().get();
    }

    public void socorrerAuto(String patente){
        System.out.println("Socorriendo auto con patente " + patente);
    }

    public void socorrerMoto(String patente){
        System.out.println("Socorriendo moto con patente " + patente);
    }
}
