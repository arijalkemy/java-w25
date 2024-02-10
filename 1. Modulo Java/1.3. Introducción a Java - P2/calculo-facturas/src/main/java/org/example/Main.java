package org.example;

public class Main {
    public static void main(String[] args) {
        int[] serviciosCli = {1,1,2,2,2,1,2}; //vector de 7 posiciones con tipos de servicios
        double totalFactura;

        for (int cli = 0; cli<serviciosCli.length; cli++) {
            if (serviciosCli[cli]==1) {
                System.out.println ("El tipo de servicio es: " + serviciosCli[cli]);
                totalFactura = 1500;
                System.out.println ("El monto de la factura es de: " + totalFactura);
            }
            else {
                System.out.println ("El tipo de servicio es: " + serviciosCli[cli]);
                totalFactura = 1500 + 700;
                System.out.println ("El monto de la factura es de: " + totalFactura);
            }
        }
    }
}