package main;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int[] serviciosCli = {1,1,2,2,2,1,2};
        double totalFactura = 1500;

        for (int i : serviciosCli) {
            if (serviciosCli[i] == 1) {
                System.out.println ("El tipo de servicio es: Servicio " + serviciosCli[i]);
                System.out.println ("El monto de la factura es de: $" + totalFactura);
            }
            else {
                System.out.println ("El tipo de servicio es: Servicio " + serviciosCli[i]);
                System.out.println ("El monto de la factura es de: $" + (totalFactura + 700));
            }
        }
    }
}