public class Ej4 {
    
    public static void main(String[] args) {
        int[] serviciosCli = {1,1,2,2,2,1,2}; //vector de 7 posiciones con tipos de servicios
        double totalFactura;
        int servicioNormal = 1;
        int servicioConPatrulla = 2;
        double precioCamaras = 1500;
        double precioPatrulla = 700;
        
        for (int i = 0; i < serviciosCli.length; i++) {
          if (serviciosCli[i] == servicioNormal) {
              totalFactura = precioCamaras;
             System.out.println ("El tipo de servicio es: " + serviciosCli[i]);
             System.out.println ("El monto de la factura es de: " + totalFactura);
          }
          else {
              totalFactura = precioCamaras + precioPatrulla;
             System.out.println ("El tipo de servicio es: " + serviciosCli[i]);
             System.out.println ("El monto de la factura es de: " + totalFactura);
          }
        }
    }
    
}
