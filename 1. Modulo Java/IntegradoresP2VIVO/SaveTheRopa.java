package IntegradoresP2VIVO;

import java.util.*;

public class SaveTheRopa {
    public static void main(String[] args) {
        // Crear prendas
        Prenda prenda1 = new Ropa("Nike", "Camiseta");
        Prenda prenda2 = new Ropa("Adidas", "Pantalón");
        Prenda prenda3 = new Ropa("Puma", "Sudadera");
        Prenda prenda4 = new Ropa("Levis", "Jeans");
        Prenda prenda5 = new Ropa("Tommy Hilfiger", "Camisa");
        Prenda prenda6 = new Ropa("Reebok", "Short");

        // Crear lista de prendas para el código 1
        List<Prenda> prendasCodigo1 = new ArrayList<>();
        prendasCodigo1.add(prenda1);
        prendasCodigo1.add(prenda2);

        // Crear lista de prendas para el código 2
        List<Prenda> prendasCodigo2 = new ArrayList<>();
        prendasCodigo2.add(prenda3);
        prendasCodigo2.add(prenda4);
        prendasCodigo2.add(prenda5);
        prendasCodigo2.add(prenda6);

        // Crear GuardaRopa
        GuardaRopa guardaRopa = new GuardaRopa();

        // Guardar prendas y recibir los códigos
        Integer codigo1 = guardaRopa.guardarPrendas(prendasCodigo1);
        System.out.println("Prendas guardadas bajo el código 1: " + codigo1);

        Integer codigo2 = guardaRopa.guardarPrendas(prendasCodigo2);
        System.out.println("Prendas guardadas bajo el código 2: " + codigo2);

        // Mostrar prendas
        guardaRopa.mostrarPrendas();

        // Consultar prendas guardadas bajo el código 1
        System.out.println("Prendas recuperadas bajo el código 1:");
        List<Prenda> prendasRecuperadas1 = guardaRopa.devolverPrendas(codigo1);
        for (Prenda prenda : prendasRecuperadas1) {
            System.out.println("- Marca: " + prenda.getMarca() + ", Modelo: " + prenda.getModelo());
        }

        // Consultar prendas guardadas bajo el código 2
        System.out.println("Prendas recuperadas bajo el código 2:");
        List<Prenda> prendasRecuperadas2 = guardaRopa.devolverPrendas(codigo2);
        for (Prenda prenda : prendasRecuperadas2) {
            System.out.println("- Marca: " + prenda.getMarca() + ", Modelo: " + prenda.getModelo());
        }
    }
    
}
// Clase abstracta Prenda
abstract class Prenda {
    private String marca;
    private String modelo;

    public Prenda(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }
}

// Clase Ropa que hereda de Prenda
class Ropa extends Prenda {
    public Ropa(String marca, String modelo) {
        super(marca, modelo);
    }
}

// Clase GuardaRopa
class GuardaRopa {
    private Map<Integer, List<Prenda>> prendas;
    private int contador;

    public GuardaRopa() {
        this.prendas = new HashMap<>();
        this.contador = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas) {
        prendas.put(++contador, listaDePrendas);
        return contador;
    }

    public void mostrarPrendas() {
        System.out.println("Prendas en el guardarropas:");
        for (Map.Entry<Integer, List<Prenda>> entry : prendas.entrySet()) {
            Integer numero = entry.getKey();
            List<Prenda> prendasGuardadas = entry.getValue();
            System.out.println("Número: " + numero);
            for (Prenda prenda : prendasGuardadas) {
                System.out.println("- Marca: " + prenda.getMarca() + ", Modelo: " + prenda.getModelo());
            }
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return prendas.getOrDefault(numero, new ArrayList<>());
    }
}
