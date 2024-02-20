import java.util.ArrayList;
import java.util.HashMap;

public class GuardaRopa {
    private static HashMap<Integer, ArrayList<Prenda>> prendas = new HashMap<>();
    private static int id = 1;

    public static Integer guardarPrendas(ArrayList<Prenda> listaPrendas) {
        prendas.put(id, listaPrendas);
        id++;
        return id-1;
    }

    public static void mostrarPrendas() {
        for (int i = 1; i <= prendas.size(); i++) {
            System.out.println("id = " + i);
            for (Prenda prenda : prendas.get(i)) {
                System.out.println(prenda);
            }
        }
    }

    public static ArrayList<Prenda> devolverPrendas(int id) {
        return prendas.get(id);
    }

    public static HashMap<Integer, ArrayList<Prenda>> getPrendas() {
        return prendas;
    }

    public static void setPrendas(HashMap<Integer, ArrayList<Prenda>> prendas) {
        prendas = prendas;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        id = id;
    }

    @Override
    public String toString() {
        return "GuardaRopa{" +
                "prendas=" + prendas +
                ", id=" + id +
                '}';
    }
}
