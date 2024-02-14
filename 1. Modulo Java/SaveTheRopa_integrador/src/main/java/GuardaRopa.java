import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GuardaRopa {
    Integer id = 0;
    private Map<Integer, List<Prenda>> prendasGuardadas = new HashMap<>();


    public int guardarPrendas(List<Prenda> listaDePrenda) {
        this.prendasGuardadas.put(id, listaDePrenda);
        id++;
        return id;
    }

    public void mostrarPrendas() {

        for (Map.Entry<Integer, List<Prenda>> prenda : prendasGuardadas.entrySet()) {
            System.out.println(prenda.getValue().toString());
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return prendasGuardadas.get(numero);
    }
}
