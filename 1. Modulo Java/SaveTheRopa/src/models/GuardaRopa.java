package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    
    private static Integer idGenerator = 0;
    private Map<Integer, List<Prenda>> map;
    
    public GuardaRopa() {
        this.map = new HashMap<>();
    }

    public Map<Integer, List<Prenda>> getMap() {
        return map;
    }

    public void setMap(Map<Integer, List<Prenda>> map) {
        this.map = map;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        map.put(++idGenerator, listaDePrenda);
        return idGenerator;
    }

    public void mostrarPrendas(){
        for (Map.Entry<Integer, List<Prenda>> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().stream().forEach(System.out::println);
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return this.map.remove(numero);
    }

    @Override
    public String toString() {
        return "GuardaRopa [map=" + map + "]";
    }
}
