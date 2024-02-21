package Streams;

public class Carro {
    String marca;
    String modelo;
    Integer año;

    public Carro(String marca, String modelo, Integer año) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
    }

    @Override
    public String toString() {
        return "Carro [marca=" + marca + ", modelo=" + modelo + ", año=" + año + "]";
    }

    public Object compareTo(Carro carro2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
    
}
