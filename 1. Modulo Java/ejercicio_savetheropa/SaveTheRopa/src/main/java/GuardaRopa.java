import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class GuardaRopa {
    private Integer id;
    private Map<Integer, List<Prenda>> ropas;

    public Integer guardarPrendas(List<Prenda> prendas) {
        id = id ++;
        ropas.put(id, prendas);
        return id;
    }

    public void mostrarPrendas() {
        for (Map.Entry<Integer, List<Prenda>> entry : ropas.entrySet()) {
            System.out.println(entry.getValue().toString());
        }
    }

    public List<Prenda> devolverPrendas(Integer id) {
        return ropas.get(id);
    }

    public GuardaRopa() {
        this.id = 0;
        this.ropas = new HashMap<Integer, List<Prenda>>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRopas(Map<Integer, List<Prenda>> ropas) {
        this.ropas = ropas;
    }

    public Map<Integer, List<Prenda>> getRopas() {
        return ropas;
    }
}
