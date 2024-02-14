import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Carrera {
    private float distancia;
    private float premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos = new ArrayList<>();

    public Carrera(float distancia, float premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public void darDeAltaAuto(float velocidad, float aceleracion, float anguloDeGiro, String patente) {
        if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos) {
            listaDeVehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
            return;
        }
        System.out.println("No se puede agregar el auto a la carrera. Límite de vehículos alcanzado.");
    }

    public void darDeAltaMoto(float velocidad, float aceleracion, float anguloDeGiro, String patente){
        if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos) {
            listaDeVehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
            return;
        }
        System.out.println("No se puede agregar la moto a la carrera. Límite de vehículos alcanzado.");
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        listaDeVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        listaDeVehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(unaPatente));
    }

    public Vehiculo definirGanador(){
        //Velocidad * ½ Aceleracion / (AnguloDeGiro*(Peso-Cantidad de Ruedas * 100)
        return listaDeVehiculos.stream().max(Comparator.comparing(vehiculo -> vehiculo.getVelocidad()*(0.5*vehiculo.getAceleracion())/(vehiculo.getAnguloDeGiro()*(vehiculo.getPeso()-vehiculo.getRuedas()*100.0)))).get();
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public float getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(float premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public void setListaDeVehiculos(List<Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
    }
}