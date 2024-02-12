package org.example;

import org.example.Productos.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Reserva {
    private long id;
    private LinkedList<Producto> productos;

    public Reserva(long id, LinkedList<Producto> productos) {
        this.id = id;
        this.productos = productos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LinkedList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(LinkedList<Producto> productos) {
        this.productos = productos;
    }

    public boolean esPaqueteCompleto() {
        Set<String> setproductos = new HashSet<>();

        productos.stream()
                .forEach(p -> {
                    setproductos.add(p.getClass().getSimpleName());
                });

        //Por ahora solo hay 4 tipos de producto
        return setproductos.size() == 4;

    }
}
