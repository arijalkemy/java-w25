package Supermercado.Models;

public class Item {
    private int id = 0;
    String nombre;
    int precio;


    public Item(String nombre, int precio) {
        this.id += 1;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    
}
