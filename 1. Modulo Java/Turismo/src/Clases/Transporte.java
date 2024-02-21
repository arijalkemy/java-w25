package Clases;

public class Transporte extends Paquete{
    public Transporte(int id, double costo){
        super(id, costo);
    }

    @Override
    public String toString() {
        return "Transporte {" +
                "id = '" + this.getId() + '\'' +
                ", Costo = " + this.getCosto() + '\'' +
                '}';
    }
}
