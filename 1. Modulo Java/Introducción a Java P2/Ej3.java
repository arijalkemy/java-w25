public class Ej3 {
    
    public static void main(String[] args) {
        double sueldoBase = 21000; //monto de ejemplo
        String dni = "12345678"; //dni de ejemplo
        double sueldoConAumento;
        double indiceAumento;
        int primerUmbral = 20000;
        int segundoUmbral = 45000;
        
        if (sueldoBase <= primerUmbral) indiceAumento = 1.2;
        else if (sueldoBase > primerUmbral && sueldoBase <= segundoUmbral) indiceAumento = 1.1;
        else indiceAumento = 1.05;
        
        sueldoConAumento = sueldoBase * indiceAumento;
        
        System.out.println ("El nuevo sueldo del empleado es de: " + sueldoConAumento);
    }
    
}
