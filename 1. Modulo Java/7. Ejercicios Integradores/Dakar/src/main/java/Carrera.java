
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaVehiculos;
    private SocorristaCarro sCarro;
    private SocorristaMoto sMoto;

    public Carrera(
            double distancia,
            double premioEnDolares,
            String nombre,
            int cantidadDeVehiculosPermitidos
    ) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaVehiculos = new ArrayList<>();
        this.sCarro = new SocorristaCarro();
        this.sMoto = new SocorristaMoto();
    }

    public double getDistancia() {
        return distancia;
    }

    public double getPremioEnDolares() {
        return premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public void setPremioEnDolares(double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public void darDeAltaAuto(double velocidad,double aceleracion,double AnguloDeGiro,String patente){
        if(listaVehiculos.size() >= cantidadDeVehiculosPermitidos){
            System.out.println("Carrera llena");
        }else{
            listaVehiculos.add(new Carro(velocidad, aceleracion, AnguloDeGiro, patente));
            System.out.println("Carro agregado correctamente");
        }
    }
    public void darDeAltaMoto(double velocidad,double aceleracion,double AnguloDeGiro,String patente){
        if(listaVehiculos.size() >= cantidadDeVehiculosPermitidos){
            System.out.println("Carrera llena");
        }else{
            listaVehiculos.add(new Moto(velocidad, aceleracion, AnguloDeGiro, patente));
            System.out.println("Moto agregado correctamente");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        // otro toc
        if(! listaVehiculos.remove(vehiculo)){
            System.out.println("Vehiculo no existe");
        }
    }

    public void eliminarVehiculoConPatente(String patente){
        listaVehiculos
                .stream()
                .filter((v) -> v.getPatente().equals(patente))
                .findFirst()
                .ifPresentOrElse(
                        vehiculo -> {
                            listaVehiculos.remove(vehiculo);
                            System.out.println("Vehículo eliminado");
                        },
                        () -> {
                            System.out.println("Vehículo no encontrado");
                        }
                );
    }

    public void ganadorCarrera(){
        Vehiculo ganador = listaVehiculos
                .stream()
                .max(Comparator.comparing(this::calcular))
                .orElse(null);

    }

    private double calcular(Vehiculo vehiculo) {
        return vehiculo.getVelocidad() * vehiculo.getAceleracion()/2 / (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100));
    }

    public void socorrerAuto(String patente){
        Vehiculo vehiculo = listaVehiculos
                .stream()
                .filter((v) -> v.getPatente().equals(patente))
                .findFirst()
                .orElse(null);

        if(vehiculo instanceof Carro){
            sCarro.socorrer((Carro) vehiculo);
        }else{
            System.out.println("No hay carro con esa patente");
        }

    }

    public void socorrerMoto(String patente){
        Vehiculo vehiculo = listaVehiculos
                .stream()
                .filter((v) -> v.getPatente().equals(patente))
                .findFirst()
                .orElse(null);

        if(vehiculo instanceof Moto){
            sMoto.socorrer((Moto) vehiculo);
        }else{
            System.out.println("No hay Moto con esa patente");
        }
    }}







