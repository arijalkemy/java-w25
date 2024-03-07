package bootcamp;

import java.util.*;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> prendas;
    private static int contador = 0;

    public GuardaRopa(){
        this.prendas = new HashMap<>();
    }
    
    public List<Prenda> devolverPrendas(Integer numero ) {
        if(this.prendas.get(numero) == null){
            return new ArrayList<>();
        }else {
            return this.prendas.get(numero);
        }
    }
    public Integer guardarPrenda(List<Prenda> p){
        contador++;
        prendas.put(Integer.valueOf(this.contador), p);
        return contador;

    }
        public void mostrarPrenda(){
            System.out.println(prendas);
        }
}
