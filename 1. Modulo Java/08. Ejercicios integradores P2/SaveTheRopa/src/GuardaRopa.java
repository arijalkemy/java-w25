import java.util.*;

public class GuardaRopa {

    Map<Integer, List<Prenda>> dict= new HashMap<>();
    private int id = 0;

    public GuardaRopa() {
    }

    public Map<Integer, List<Prenda>> getDict() {
        return dict;
    }

    public void setDict(Map<Integer, List<Prenda>> dict) {
        this.dict = dict;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        id = + 1;
        dict.put(id,listaDePrenda);
        return id;
        
    }

    public void mostrarPrendas(){
        dict.forEach((key,value) -> {
            System.out.println("Numero"+ key+ " Prendas"+ value.toString());
        });
        for(Map.Entry<Integer, List<Prenda>> prendas:  dict.entrySet()){
            System.out.println("Numero:" + prendas.getKey() + "Prendas" + prendas.getValue());
        }
    }
    public List<Prenda> devolverPrendas(Integer numero){
        return dict.get(numero);
    }
}
