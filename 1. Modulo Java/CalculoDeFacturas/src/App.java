public class App {
    public static void main(String[] args) throws Exception {
        Integer[] serviciosCli = {1,1,2,2,2,1,2};
        double totalFactura = 0;

        for(Integer i=0;i<serviciosCli.length;i++) {
        if(serviciosCli[i]==1) {
            totalFactura = 1500;
            System.out.println ("El tipo de servicio es: " + serviciosCli[i]);
            System.out.println ("El monto de la factura es de: " + totalFactura);
        }
        else {
            totalFactura = 2200;
            System.out.println ("El tipo de servicio es: " + serviciosCli[i]);
            System.out.println ("El monto de la factura es de: " + totalFactura);
        }
        }
    }
}
