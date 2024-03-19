package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositorioLocalizador {

    List<Localizador> localizadorList;

    public RepositorioLocalizador(){
        this.localizadorList = new ArrayList<>(){
        };
    }

    public List<Localizador> getLocalizadorList() {
        return localizadorList;
    }

    @Override
    public String toString() {
        return "RepositorioLocalizador{" +
                "localizadorList=" + localizadorList +
                '}';
    }

    public void agregarLocalizador(Cliente cliente){
        PaqueteTuristico paquete = new PaqueteTuristico();
        Localizador localizador = new Localizador(cliente, paquete.paqueteCompleto(), paquete.totalValor());
        localizadorList.add(aplicarDescuento(localizador));
    }

    private Localizador aplicarDescuento(Localizador localizador){

        double desc = 1;
        if((localizador.getPaquete().size() == 4)){
            desc = desc - 0.1;
        }
        Cliente cliente = localizador.getCliente();
        if(localizadorList.stream().filter(loc -> loc.getCliente().equals(cliente)).count() > 1){
            desc = desc - 0.05;
        }
        localizador.setTotal(localizador.getTotal()*desc);
        return localizador;

    }



}
