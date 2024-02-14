package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private int contador;
    private Map<Integer, List<Prenda>> listaDePrendas;

    public GuardaRopa() {
        this.contador = 0;
        this.listaDePrendas = new HashMap<>();
    }

    // 3
    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        this.contador++;
        listaDePrendas.put(this.contador, listaDePrenda);
        return this.contador;
    }

    // 4
    public void mostrarPrendas() {
        for (Map.Entry<Integer, List<Prenda>> entrada : listaDePrendas.entrySet()) {
            Integer clave = entrada.getKey();
            List<Prenda> valor = entrada.getValue();
            System.out.println("ID: " + clave + "\nPrendas: " + valor);
        }
    }

    // 5
    public List<Prenda> devolverPrendas(Integer numero) {
        List<Prenda> prendaSeleccionada = new ArrayList<>();
        for (Map.Entry<Integer, List<Prenda>> entrada : listaDePrendas.entrySet()) {
            if (numero == entrada.getKey()) {
                prendaSeleccionada = entrada.getValue();
            }
        }
        return prendaSeleccionada;
    }

}
