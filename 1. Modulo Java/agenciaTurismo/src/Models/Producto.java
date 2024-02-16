package Models;

import enums.EnumProductType;

public  class Producto {
    private int id;
    private double precio;
    private String description;
    private EnumProductType type;

    public Producto() {
    }

    public Producto(int id, double precio, String description, EnumProductType type) {
        this.id = id;
        this.precio = precio;
        this.description = description;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EnumProductType getType() {
        return type;
    }

    public void setType(EnumProductType type) {
        this.type = type;
    }
}
