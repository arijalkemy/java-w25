package Clases;

public class BoletoViaje extends Paquete{
    public BoletoViaje(int id, double costo){
        super(id,costo);
    }

    @Override
    public String toString() {
        return "BoletoViaje {" +
                "id = '" + this.getId() + '\'' +
                ", Costo = " + this.getCosto() + '\'' +
                '}';
    }

}
