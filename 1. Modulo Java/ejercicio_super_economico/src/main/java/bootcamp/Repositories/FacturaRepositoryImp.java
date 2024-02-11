package bootcamp.Repositories;

import bootcamp.Model.Factura;

import java.util.List;
import java.util.Optional;

public class FacturaRepositoryImp implements ICRUD<Factura> {
    List<Factura> facturas;


    @Override
    public void save(Factura saved) {
        facturas.add(saved);
    }

    @Override
    public List<Factura> getAll() {
        return this.facturas;
    }



    @Override
    public void remove(Factura removed) {
         facturas.remove(removed);

    }
}
