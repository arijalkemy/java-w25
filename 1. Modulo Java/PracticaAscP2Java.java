public class PracticaAscP2 {
    public static void main(String[] args) {
        //Punto 1
        double sueldoBase = 21000; //monto de ejemplo
        String dni = "12345678"; //dni de ejemplo
        double sueldoConAumento;

        if (sueldoBase<=20000) {
            sueldoConAumento=sueldoBase+(sueldoBase*0.2);
        }else {
            if (sueldoBase>20000 || sueldoBase<=45000){
                sueldoConAumento=sueldoBase+(sueldoBase*0.1);
            }
            else {
                sueldoConAumento=sueldoBase+(sueldoBase*0.05);
            }
        }
        System.out.println ("El nuevo sueldo del empleado es de: " + sueldoConAumento);

        //Punto 2
        int serviciosCli[] = {1,1,2,2,2,1,2}; //vector de 7 posiciones con tipos de servicios

        for (int i=0; i<serviciosCli.length; i++) {
            if (serviciosCli[i]==1) {             
                System.out.println ("El tipo de servicio es: " + serviciosCli[i]);
                System.out.println ("El monto de la factura es de: " + 1500);
            }
            else {
                System.out.println ("El tipo de servicio es: " + serviciosCli[i]);
                System.out.println ("El monto de la factura es de: " + 2200);
            }
        }
    }    
}
