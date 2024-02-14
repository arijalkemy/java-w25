public class Main {
    public static void main(String[] args) {
        int[] serviciosCli = new int[]{1, 1, 2, 2, 2, 1, 2}; //vector de 7 posiciones con tipos de servicios
        double totalFactura;

        for (int i : serviciosCli) {
            if (serviciosCli[i] == 1) {
                System.out.println ("El tipo de servicio es: " + serviciosCli[i]);
                totalFactura = 1500;
                System.out.println ("El monto de la factura es de: " + totalFactura);
            }
            else if (serviciosCli[i] == 2){
                System.out.println ("El tipo de servicio es: " + serviciosCli[i]);
                totalFactura = 1500 + 700;
               System.out.println ("El monto de la factura es de: " + totalFactura);
            }
        }

    }
}
