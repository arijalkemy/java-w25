package Clases;

public class Comida extends Paquete{

    public Comida(int id, double costo){
        super(id,costo);
    }

    @Override
    public String toString() {
        return "Comida {" +
                "id = '" + this.getId() + '\'' +
                ", Costo = " + this.getCosto() + '\'' +
                '}';
    }
}
