import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermi;
    private List<Vehiculo> listaDeVehiculos = new ArrayList<>();
    private SocorristaAuto socorristaAuto = new SocorristaAuto();
    private SocorristaMoto socorristaMoto = new SocorristaMoto();

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermi) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermi = cantidadDeVehiculosPermi;
    }

    public double getDistancia() {return distancia;}

    public void setDistancia(double distancia) {this.distancia = distancia;}

    public double getPremioEnDolares() {return premioEnDolares;}

    public void setPremioEnDolares(double premioEnDolares) {this.premioEnDolares = premioEnDolares;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public int getCantidadDeVehiculosPermi() {return cantidadDeVehiculosPermi;}

    public void setCantidadDeVehiculosPermi(int cantidadDeVehiculosPermi) {this.cantidadDeVehiculosPermi = cantidadDeVehiculosPermi;}

    public List<Vehiculo> getListaDeVehiculos() {return listaDeVehiculos;}

    public void setListaDeVehiculos(List<Vehiculo> listaDeVehiculos) {this.listaDeVehiculos = listaDeVehiculos;}

    public void darDeAltaCarro(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        if (!(listaDeVehiculos.toArray().length < cantidadDeVehiculosPermi)) {
            System.out.println("No hay cupo disponible para dar de alta un carro");
            return;
        }

        Carro carro = new Carro(velocidad, aceleracion, anguloDeGiro, patente);

        for (Vehiculo vehiculo : listaDeVehiculos) {
            if (vehiculo.getPatente().equals(carro.getPatente())) {
                System.out.println("El carro ya estaba inscrito");
                return;
            }
        }

        listaDeVehiculos.add(carro);
        System.out.println("Se agregó carro");
    }

    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        if (!(listaDeVehiculos.toArray().length < cantidadDeVehiculosPermi)) {
            System.out.println("No hay cupo disponible para dar de alta una moto");
            return;
        }

        Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);

        for (Vehiculo vehiculo : listaDeVehiculos) {
            if (vehiculo.getPatente().equals(moto.getPatente())) {
                System.out.println("La moto ya estaba inscrita");
                return;
            }
        }

        listaDeVehiculos.add(moto);
        System.out.println("Se agregó moto");
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        listaDeVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculo(String patente){
        Vehiculo vehiculoAEliminar= listaDeVehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equals(patente)).findFirst().orElse(null);
        listaDeVehiculos.remove(vehiculoAEliminar);
    }

    public Vehiculo obtenerGanador(){
        double maxFormula = 0;
        Vehiculo maxVehiculo = null;
        for (Vehiculo vehiculo : listaDeVehiculos){
            if(maxFormula < ((vehiculo.getVelocidad()*(vehiculo.getAceleracion()/2))/(vehiculo.getAnguloDeGiro()*(vehiculo.getPeso()-vehiculo.getRuedas()*100)))){
                maxFormula = ((vehiculo.getVelocidad()*(vehiculo.getAceleracion()/2))/(vehiculo.getAnguloDeGiro()*(vehiculo.getPeso()-vehiculo.getRuedas()*100)));
                maxVehiculo = vehiculo;
            }
        }
        return maxVehiculo;
    }

    public void socorrerAuto(String patente){
        Carro autoASocorrer = (Carro) listaDeVehiculos.stream().filter(x -> x.getPatente().equals(patente)).findFirst().orElse(null);

        if (autoASocorrer != null) {
            socorristaAuto.socorrer(autoASocorrer);
        } else {
            System.out.println("No existe el vehículo");
        }
    }

    public void socorrerMoto(String patente){
        Moto motoASocorrer = (Moto) listaDeVehiculos.stream().filter(x -> x.getPatente().equals(patente)).findFirst().orElse(null);

        if (motoASocorrer != null) {
            socorristaMoto.socorrer(motoASocorrer);
        } else {
            System.out.println("No existe el vehículo");
        }
    }

}
