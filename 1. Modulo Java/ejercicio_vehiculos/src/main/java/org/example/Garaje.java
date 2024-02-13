import java.util.*;

public class Garaje {
    int identificador;
    List<Vehiculo> vehiculos;

    public Garaje(
            int identificador,
            List<Vehiculo> vehiculos
    ) {
        this.identificador = identificador;
        this.vehiculos = vehiculos;
    }

    public int getIdentificador() { return this.identificador; }
    public List<Vehiculo> getVehiculos() { return this.vehiculos; }

    public  void setIdentificador(int identificador) { this.identificador = identificador; }
    public void setVehiculos(List<Vehiculo> vehiculos) { this.vehiculos = vehiculos; }

    public void sortGarage(){
        this.vehiculos.sort(Comparator.comparing(Vehiculo::getCosto));
    }
}
