
import java.util.ArrayList;
import java.util.List;

import classes.*;

public class App {
        public static void main(String[] args) throws Exception {
                GuardaRopa guardaRopa1 = new GuardaRopa();
                Prenda prenda1 = new Prenda("adidas", "remera");
                Prenda prenda2 = new Prenda("nike", "short");
                Prenda prenda3 = new Prenda("puma", "zapatillas");

                List<Prenda> lista1 = new ArrayList<>();
                lista1.add(prenda1);
                lista1.add(prenda2);
                List<Prenda> lista2 = new ArrayList<>();
                lista2.add(prenda3);

                System.out.println(guardaRopa1.guardarPrendas(lista1));
                System.out.println(guardaRopa1.guardarPrendas(lista2));

                guardaRopa1.mostrarPrendas();

                System.out.println(guardaRopa1.devolverPrendas(1));

        }
}
