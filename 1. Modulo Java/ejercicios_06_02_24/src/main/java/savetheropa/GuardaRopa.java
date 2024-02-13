package savetheropa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Integer contador;
    private Map<Integer, List<Prenda>> guardarropa;

    public GuardaRopa() {
        contador = 0;
        guardarropa = new HashMap<>();
    }

    public GuardaRopa(Integer contador, Map<Integer, List<Prenda>> guardarropa) {
        this.contador = contador;
        this.guardarropa = guardarropa;
    }

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }

    public Map<Integer, List<Prenda>> getGuardarropa() {
        return guardarropa;
    }

    public void setGuardarropa(Map<Integer, List<Prenda>> guardarropa) {
        this.guardarropa = guardarropa;
    }

    public Integer guardarPrendas(List<Prenda> prendas) {
        guardarropa.put(contador, prendas);
        return contador++;
    }

    public void mostrarPrendas() {
        guardarropa.forEach((clave, prendas) -> {
            System.out.println("----- Código de Guardarropa: " + clave + " -----");
            prendas.forEach(System.out::println);
        });
    }

    public void devolverPrendas(Integer numero) {
        List<Prenda> prendas = guardarropa.get(numero);
        if (prendas != null) {
            System.out.println(prendas);
        } else {
            System.out.println("No se encontraron prendas con el número de código proporcionado.");
        }
    }
}
