package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class RepositorioCliente {

    List<Cliente> listaClientes;

    public RepositorioCliente() {
        this.listaClientes = new ArrayList<>();
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    @Override
    public String toString() {
        return "RepositorioCliente{" +
                "listaClientes=" + listaClientes +
                '}';
    }

    public void agregarCliente(RepositorioLocalizador repoLoc){
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Digite su dni: ");
        int dni = Integer.parseInt(keyboard.nextLine());

        Optional<Cliente> clienteExistente = listaClientes.stream().filter(c -> c.getDni() == dni).findFirst();
        if(clienteExistente.isPresent()){
            repoLoc.agregarLocalizador(clienteExistente.get());
        }else{
            System.out.println("Digite su nombre: ");
            String nombre = keyboard.nextLine();
            listaClientes.add(new Cliente((long) listaClientes.size() + 100, nombre, dni));
            repoLoc.agregarLocalizador(listaClientes.get(listaClientes.size() - 1));
        }
    }
}
