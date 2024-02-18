public class Vehiculo {
    private String modelo;
    private String marca;
    private int precio;

    private int anio;

    public Vehiculo(String marca, String modelo, int precio, int anio) {
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
        this.anio = anio;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public int getPrecio() {
        return this.precio;
    }

    public int getAnio() {
        return this.anio;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Vehiculo aplicarDescuento(int descuento) {
        return new Vehiculo(this.marca, this.modelo, this.precio - (descuento * this.precio / 100), this.anio);
    }

    @Override
    public String toString(){
        return this.marca + " " + this.modelo + " ($" + this.precio + ")";
    }
}