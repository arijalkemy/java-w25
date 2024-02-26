package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PracticaExcepciones pe = new PracticaExcepciones();
        try {
            pe.calculate();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        Distribuidora distribuidora = new Distribuidora();
        double total = distribuidora.calcularPrecioTotalPorCantidad(5);
        System.out.println("Precio total al vender 5 productos de cada tipo: " + total);
    }
}