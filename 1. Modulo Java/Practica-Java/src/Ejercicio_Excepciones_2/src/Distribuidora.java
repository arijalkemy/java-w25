package Ejercicio_Excepciones_2.src;

import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) {
        ArrayList<Producto> lista = new ArrayList();
        double sumaProductoGeneral = 0;
        double sumaPerecedero = 0;
        double sumaNoPerecedero = 0;

        //Productos
        lista.add(new Producto("Escoba", 3180));
        lista.add(new Producto("Detergente", 1650));
        lista.add(new Producto("Plato", 2800));
        lista.add(new Producto("Botella", 1500));
        lista.add(new Producto("Cuchiclo", 1300));

        //Perecederos
        lista.add(new Perecedero("Leche", 920, 50));
        lista.add(new Perecedero("Manteca", 1300, 3));
        lista.add(new Perecedero("Yogurt", 800, 2));
        lista.add(new Perecedero("Queso", 3599, 50));

        //NoPerecederos
        lista.add(new NoPerecedero("Fideos", 920, "Pasta"));
        lista.add(new NoPerecedero("Arroz", 920, "Conserva"));
        lista.add(new NoPerecedero("Atun", 920, "Enlatado"));
        lista.add(new NoPerecedero("Garbanzos", 920, "Enlatado"));
        lista.add(new NoPerecedero("Arbejas", 920, "Enlatado"));

        for(Producto prod : lista){
            if(prod instanceof Perecedero){
                sumaPerecedero += prod.calcular(1);
            }
            else if(prod instanceof NoPerecedero){
                sumaNoPerecedero += prod.calcular(1);
            }
            else {
                sumaProductoGeneral += prod.calcular(1);
            }
        }

        System.out.println("El precio de los productos generales es: " + sumaProductoGeneral);
        System.out.println("El precio de los productos Perecederos es: " + sumaPerecedero);
        System.out.println("El precio de los productos No Perecederos es: " + sumaNoPerecedero);
    }
}