package Repository;

import model.Cliente;
import model.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImp implements CRUDRepository<Factura> {
    List<Factura> listaFacturas = new ArrayList<>();
    @Override
    public void save(Factura objeto) {
        listaFacturas.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
        for(Factura obj:listaFacturas) System.out.println(obj.toString());
    }

    @Override
    public Optional<Factura> buscar(long codigo) {
        for(Factura fact: listaFacturas){
            if(fact.getCodigo()==codigo){
                System.out.println("Factura encontrado:");
                System.out.println(fact.toString());
                return Optional.of(fact);
            }
        }
        System.out.println("Ups, no existe una factura con dicho codigo...");
        return Optional.empty();
    }

    @Override
    public void eliminar(long cod) {
        Optional<Factura> fact = this.buscar(cod);
        if(fact.isEmpty()){
            System.out.println("Factura no encontrado");
        }
        else{
            listaFacturas.remove(fact.get());
            System.out.println("Factura borrada correctamente");
        }
    }

    @Override
    public List<Factura> traerTodos() {
        return listaFacturas;
    }
}
