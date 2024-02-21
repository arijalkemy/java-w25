package Clases;


public abstract class Paquete {
    private int id;


    private double costo;

    public Paquete(int id, double costo) {
        this.id = id;
        this.costo = costo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public double getCosto(){
        return this.costo;
    }
    public void setCosto(double costo){
        this.costo = costo;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
