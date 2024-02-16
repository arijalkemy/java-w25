package Repositories;

import Interfaces.ICRUD;
import Models.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProductoRepository implements ICRUD<Producto> {
    public static List<Producto> productoList = new ArrayList<>();

    @Override
    public void create(Producto producto) {
        if (productoList.stream().noneMatch(c -> c.getType().equals(producto.getType()))) {
            int id = !productoList.isEmpty() ? productoList.get(productoList.size() -1).getId() + 1 : 1;
            producto.setId(id);
            productoList.add(producto);
        }
    }

    @Override
    public List<Producto> read() {
        return productoList;
    }

    @Override
    public void update(Producto producto) {
        Producto productoEncontrado = findById(producto.getId());
        if (productoEncontrado != null) {
            productoList.remove(productoEncontrado);
            productoList.add(producto);
        } else {
            System.out.println("Producto no existe");
        }
    }


    @Override
    public Producto findById(int clienteId) {
        return productoList.stream().filter(c -> c.getId() == clienteId).findFirst().orElse(null);



    }

    @Override
    public void delete(Producto producto) {
        Producto productoEncontrado = findById(producto.getId());
        if (productoEncontrado != null) {
            productoList.remove(productoEncontrado);
        } else {
            System.out.println("Producto no existe");
        }

    }
}
