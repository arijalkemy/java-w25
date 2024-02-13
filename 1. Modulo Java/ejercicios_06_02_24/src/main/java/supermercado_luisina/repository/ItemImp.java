package supermercado_luisina.repository;

import supermercado_luisina.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemImp implements CrudRepository<Item> {

    List<Item> items = new ArrayList<>();

    @Override
    public void save(Item i) {
        items.add(i);
    }

    @Override
    public void mostrar() {
        for (Item i : items) {
            System.out.println("-----Item-----");
            System.out.println(i.toString());
        }
    }

    @Override
    public Optional<Item> buscar(Long codigoBuscar) {
        boolean itemEncontrado = false;

        for (Item i : items) {
            if (i.getCodigo().equals(codigoBuscar)) {
                System.out.println("-----Item encontrado:-----");
                System.out.println(i.toString());
                return Optional.of(i);
            }
        }

        if (!itemEncontrado) {
            System.out.println("No se encontró el item.");
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(Long codigoEliminar) {
        Optional<Item> itemBuscar = this.buscar(codigoEliminar);

        if (itemBuscar.isEmpty()) {
            System.out.println("No se encontró el item a eliminar.");
        } else {
            items.remove(itemBuscar.get());
            System.out.println("Item eliminado correctamente.");
        }
    }

    @Override
    public List<Item> traerTodos() {
        return items;
    }
}
