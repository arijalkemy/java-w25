import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Integer contador;
    private Map<Integer, List<Prenda>> diccionario;

    public GuardaRopa(){
        this.contador = 0;
        this.diccionario = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        diccionario.put(++contador,listaDePrenda);
        return contador;
    }

    public void mostrarPrendas(){
        for(Integer key : diccionario.keySet()){
            List<Prenda> listaDePredas = diccionario.get(key);
            listaDePredas.stream().forEach(System.out::println);
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        List<Prenda> listaPrendas = diccionario.get(numero);
        diccionario.remove(numero);
        return listaPrendas;
    }
}
