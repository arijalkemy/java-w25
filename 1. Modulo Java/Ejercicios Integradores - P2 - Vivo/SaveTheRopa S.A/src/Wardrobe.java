import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wardrobe {
    private Map<Integer, List<Clothing>> dictionary = new HashMap<>();
    private Integer counter = 0;

    public Integer storeClothes(List<Clothing> clothesList){
        dictionary.put(counter, clothesList);
        return counter++;
    }

    public void showClothes() {
        for (Map.Entry<Integer, List<Clothing>> entry : dictionary.entrySet()) {
            System.out.println("Identificador: " + entry.getKey());
            for (Clothing clothing : entry.getValue()) {
                System.out.println(clothing);
            }
        }
    }

    public List<Clothing> returnClothes(Integer identifier) {
        return dictionary.get(identifier);
    }
}
