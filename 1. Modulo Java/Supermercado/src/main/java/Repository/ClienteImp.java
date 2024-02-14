package Repository;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteImp implements CRUDRepository <Cliente>{
    List<Cliente> clientes = new ArrayList<>();

    @Override
    public void save(Cliente objeto) {
        clientes.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
        for(Cliente obj:clientes) System.out.println(obj.toString());
    }

    @Override
    public Optional<Cliente> buscar(long dni) {

        for(Cliente cli: clientes){
            if(cli.getDni()==dni){
                System.out.println("model.Cliente encontrado:");
                System.out.println(cli.toString());
                return Optional.of(cli);
            }
        }
        System.out.println("Ups, no existe un cliente con dicho DNI...");
        return Optional.empty();
    }

    @Override
    public void eliminar(long dniBorrar) {
        Optional<Cliente> cli = this.buscar(dniBorrar);
        if(cli.isEmpty()){
            System.out.println("Cliente no encontrado");
        }
        else{
            clientes.remove(cli.get());
            System.out.println("Cliente borrado correctamente");
        }
    }

    @Override
    public List<Cliente> traerTodos() {
        return clientes;
    }
}
