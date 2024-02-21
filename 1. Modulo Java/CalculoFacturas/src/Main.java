//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] serviciosCli = {1, 1, 2, 2, 2, 1, 2, 2}; // vector de 7 posiciones con tipos de servicios
        double totalFactura = 0;

        for (int i = 0; i < serviciosCli.length; i++) {
            double servicio1 = 1500;
            double servicio2 = 2200;
            if (serviciosCli[i] == 1) {
                totalFactura += servicio1;
            } else if (serviciosCli[i] == 2) {
                totalFactura += servicio2;
            }
            System.out.println("El tipo de servicio es: " + serviciosCli[i]);
            System.out.println("El monto de la factura es de: " + totalFactura);
        }
    }
}