package org.example;

public class Automovil {


        String marca;
        String color;
        double kilometros;

        public Automovil() {

        }

        public Automovil(String marca, String color, Double kilometros) {
            this.marca = marca;
            this.color = color;
            this.kilometros = kilometros;
        }

        public String mostrarMarcaYColor() {
            String marcaYColor = "La marca del auto es: " + this.marca + ". El color del auto es: " + this.color;
            return marcaYColor;
        }


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Automovil{" +
                "marca='" + marca + '\'' +
                ", color='" + color + '\'' +
                ", kilometros=" + kilometros +
                '}';
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getKilometros() {
        return kilometros;
    }

    public void setKilometros(double kilometros) {
        this.kilometros = kilometros;
    }
}
