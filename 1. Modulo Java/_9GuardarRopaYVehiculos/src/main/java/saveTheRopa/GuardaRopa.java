package saveTheRopa;

import java.util.*;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> guardaropa;
    private int contadorIdentificacion;

    public GuardaRopa() {
        this.guardaropa = new HashMap<>();
        this.contadorIdentificacion = 0;
    }
    public GuardaRopa(Map<Integer, List<Prenda>> guardaropa) {
        this.guardaropa = guardaropa;
        this.contadorIdentificacion = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        this.guardaropa.put(this.contadorIdentificacion, listaDePrenda);
        return this.contadorIdentificacion++;
    }

    public void mostrarPrendas(){
        System.out.println(this.guardaropa);
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        if (guardaropa.containsKey(numero)) {
            List<Prenda> pertenencias = guardaropa.get(numero);
            guardaropa.remove(numero);
            return pertenencias;
        }
        System.out.println("Error: No se encontraron prendas asociadas al numero identificador.");
        return null;
    }
}
