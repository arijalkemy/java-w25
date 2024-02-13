public class Vehiculo {
    String modelo;
    String marca;
    double costo;

    public Vehiculo(String modelo, String marca, double costo) {
        this.modelo = modelo;
        this.marca = marca;
        this.costo = costo;
    }

    public java.lang.String getModelo() {
        return modelo;
    }

    public void setModelo(java.lang.String modelo) {
        this.modelo = modelo;
    }

    public java.lang.String getMarca() {
        return marca;
    }

    public void setMarca(java.lang.String marca) {
        this.marca = marca;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return String.valueOf(this.getCosto());
    }
}
