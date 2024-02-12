import java.util.ArrayList;
import java.util.Arrays;

public class Carrera {
    private double distancia;
    private double premio;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private ArrayList<Vehiculo> listaDeVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (cantidadDeVehiculosPermitidos > listaDeVehiculos.size()) {
            listaDeVehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (cantidadDeVehiculosPermitidos > listaDeVehiculos.size()) {
            listaDeVehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        listaDeVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente) {
        Vehiculo vehiculoARemover = (Vehiculo) listaDeVehiculos.stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(patente));

        eliminarVehiculo(vehiculoARemover);
    }

    public Vehiculo calcularGanador() {
        Vehiculo ganador;
        // velocidad * 0.5 * aceleracion / (anguloDeGiro * (peso - cantidadDeRuedas * 100)
        
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremio() {
        return premio;
    }

    public void setPremio(double premio) {
        this.premio = premio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDeVehiculos() {
        return cantidadDeVehiculos;
    }

    public void setCantidadDeVehiculos(int cantidadDeVehiculos) {
        this.cantidadDeVehiculos = cantidadDeVehiculos;
    }

    public ArrayList<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public void setListaDeVehiculos(ArrayList<Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
    }

    public SocorristaAuto getSocorristaAuto() {
        return socorristaAuto;
    }

    public void setSocorristaAuto(SocorristaAuto socorristaAuto) {
        this.socorristaAuto = socorristaAuto;
    }

    public SocorristaMoto getSocorristaMoto() {
        return socorristaMoto;
    }

    public void setSocorristaMoto(SocorristaMoto socorristaMoto) {
        this.socorristaMoto = socorristaMoto;
    }

    public Carrera(double distancia, double premio, String nombre, int cantidadDeVehiculos, ArrayList<Vehiculo> listaDeVehiculos, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.premio = premio;
        this.nombre = nombre;
        this.cantidadDeVehiculos = cantidadDeVehiculos;
        this.listaDeVehiculos = listaDeVehiculos;
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
    }
}
