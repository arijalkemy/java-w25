package org.example;

import java.util.List;

public class Garage {
    int id;
    List<Vehiculo> vehiculos;


    public Garage(int id) {
        this.id = id;
    }

    public Garage(List<org.example.Vehiculo> vehiculos) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "id=" + id +
                ", vehiculos=" + vehiculos +
                '}';
    }

    public static class Vehiculo {
        String modelo;
        String marca;
        int costo;

        public Vehiculo(String modelo, String marca, int costo) {
            this.modelo = modelo;
            this.marca = marca;
            this.costo = costo;
        }

        public String getModelo() {
            return modelo;
        }

        public void setModelo(String modelo) {
            this.modelo = modelo;
        }

        public String getMarca() {
            return marca;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        public int getCosto() {
            return costo;
        }

        public void setCosto(int costo) {
            this.costo = costo;
        }
    }
}
