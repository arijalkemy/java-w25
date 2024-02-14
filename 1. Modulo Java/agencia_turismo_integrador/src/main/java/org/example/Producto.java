package org.example;

public abstract class Producto {

    private int id;
    private String productName;
    private double precio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Producto(int id, String productName, double precio) {
        this.id = id;
        this.productName = productName;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", precio=" + precio +
                '}';
    }
}
