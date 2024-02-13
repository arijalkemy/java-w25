package dakar;

import java.util.List;

public class Carrera {
    private Double distancia;
    private Double premio;
    private String nombre;
    private Integer cantVehiculos;
    private List<Vehiculo> vehiculos;

    public Carrera() {
    }

    public Carrera(Double distancia, Double premio, String nombre, Integer cantVehiculos, List<Vehiculo> vehiculos) {
        this.distancia = distancia;
        this.premio = premio;
        this.nombre = nombre;
        this.cantVehiculos = cantVehiculos;
        this.vehiculos = vehiculos;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Double getPremio() {
        return premio;
    }

    public void setPremio(Double premio) {
        this.premio = premio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantVehiculos() {
        return cantVehiculos;
    }

    public void setCantVehiculos(Integer cantVehiculos) {
        this.cantVehiculos = cantVehiculos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void darDeAltaAuto(Double velocidad, double aceleracion, Double anguloDeGiro, String patente) {
        if (vehiculos.size() < cantVehiculos) {
            vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
            System.out.println("Auto dado de alta correctamente.");
        } else {
            System.out.println("Cupos acabados.");
        }
    }

    public void darDeAltaMoto(Double velocidad, double aceleracion, Double anguloDeGiro, String patente) {
        if (vehiculos.size() < cantVehiculos) {
            System.out.println("Moto dada de alta correctamente.");
            vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
        } else {
            System.out.println("Cupos acabados.");
        }
    }

    public void eliminarVehiculo(Vehiculo v) {
        try {
            vehiculos.remove(v);
        } catch (Exception e) {
            throw new RuntimeException("Vehículo no encontrado.");
        }
    }

    public void eliminarVehiculoPorPatente(String patente) {
        try {
            vehiculos.removeIf(vehiculo -> vehiculo.getPatente().equalsIgnoreCase(patente));
        } catch (Exception e) {
            throw new RuntimeException("Vehículo no encontrado.");
        }
    }

    public Vehiculo obtenerGanador() {
        Vehiculo vehiculoGanador = null;
        double puntaje = 0;

        for (Vehiculo v : vehiculos) {
            if (calcularPuntaje(v) > puntaje) {
                puntaje = calcularPuntaje(v);
                vehiculoGanador = v;
            }
        }
        return vehiculoGanador;
    }

    public double calcularPuntaje(Vehiculo v) {
        return v.getVelocidad() * (v.getAceleracion() / 2) / (v.getAnguloGiro() * (v.getPeso() - v.getCantRuedas()));
    }
}
