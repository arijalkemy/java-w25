import Clases.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Lionel","Messi","12312312");

        List<Paquete> listaPaquete = List.of(
                new Comida(1, 1500.50),
                new Transporte(10, 2500.0),
                new BoletoViaje(10, 2500.0)
        );
        Localizador localizador1 = new Localizador(cliente,listaPaquete) ;

        //calcularDescuento();

        System.out.println(localizador1.toString());
    }

    public static double calcularDescuento(){

        return 0.0;
    }
}