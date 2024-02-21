package Ejercicio_Supermercado;

public class Item {
    private int codigo;
    private String nombre;
    private int cantComprada;
    private double costoUnit;

    public Item(int codigo, String nombre, int cantComprada, double costoUnit) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantComprada = cantComprada;
        this.costoUnit = costoUnit;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantComprada() {
        return cantComprada;
    }

    public void setCantComprada(int cantComprada) {
        this.cantComprada = cantComprada;
    }

    public double getCostoUnit() {
        return costoUnit;
    }

    public void setCostoUnit(double costoUnit) {
        this.costoUnit = costoUnit;
    }
}
