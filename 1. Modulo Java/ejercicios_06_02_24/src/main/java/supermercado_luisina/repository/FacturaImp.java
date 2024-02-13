package supermercado_luisina.repository;

import supermercado_luisina.model.Factura;
import supermercado_luisina.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImp implements CrudRepository<Factura> {

    List<Factura> facturas = new ArrayList<>();
    ClienteImp clienteImp = new ClienteImp();

    @Override
    public void save(Factura f) {

        Optional<Cliente> clienteBuscar = clienteImp.buscar(f.getCliente().getDni());

        if (clienteBuscar.isEmpty()) {
            System.out.println("El cliente ingresado para la factura no existe.");
        } else {
            facturas.add(f);
        }
    }

    @Override
    public void mostrar() {
        for (Factura f : facturas) {
            System.out.println("-----Factura-----");
            System.out.println(f.toString());
        }
    }

    @Override
    public Optional<Factura> buscar(Long codigoBuscar) {
        boolean facturaEncontrada = false;

        for (Factura f : facturas) {
            if (f.getCodigo().equals(codigoBuscar)) {
                System.out.println("Factura encontrada.");
                //System.out.println(f.toString());
                return Optional.of(f);
            }
        }

        if (!facturaEncontrada) {
            System.out.println("No se encontró la factura.");
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(Long codigoEliminar) {
        Optional<Factura> facturaBuscar = this.buscar(codigoEliminar);

        if (facturaBuscar.isEmpty()) {
            System.out.println("No se encontró la factura a eliminar.");
        } else {
            facturas.remove(facturaBuscar.get());
            System.out.println("Factura eliminada correctamente.");
        }
    }

    @Override
    public List<Factura> traerTodos() {
        return facturas;
    }
}
