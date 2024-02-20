import java.util.List;
import java.util.Optional;

public class Carrera {

    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos, List<Vehiculo> listaDeVehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = listaDeVehiculos;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(Double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(Integer cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public void setListaDeVehiculos(List<Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        this.listaDeVehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        this.listaDeVehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        this.listaDeVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        Optional<Vehiculo> vehiculoOptional = this.listaDeVehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equals(unaPatente)).findFirst();
        if (vehiculoOptional.isPresent()) {
            this.listaDeVehiculos.remove(vehiculoOptional.get());
        }
    }

    public void definirGanador(){
        Vehiculo ganador = null;
        double topSpeed = -999;

        this.listaDeVehiculos.forEach(vehiculo -> {
            topSpeed = vehiculo.getVelocidad() * (vehiculo.getAceleracion()/2) / (vehiculo.getAnguloDeGiro()*(vehiculo.getPeso()- vehiculo.getRuedas()*100));


        });
    }


}
