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

    public void calcularGanador() {
        String ganador = "";
        double velocidadGanador = 0;
        for (Vehiculo v : listaDeVehiculos) {
            double resultado = v.getVelocidad() * 0.5 * v.getAceleracion() / (v.getAnguloDeGiro() * (v.getPeso() - v.getRuedas() * 100));
            if (resultado >= velocidadGanador) {
                ganador = v.getPatente();
                velocidadGanador = resultado;
            }
        }
        System.out.println("El vehiculo ganador es " + ganador);
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
        return this.cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculos(int cantidad) {
        this.cantidadDeVehiculosPermitidos = cantidad;
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

    public Carrera(double distancia, double premio, String nombre, int cantidadDeVehiculosPermitidos, ArrayList<Vehiculo> listaDeVehiculos, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.premio = premio;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = listaDeVehiculos;
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
    }
}
