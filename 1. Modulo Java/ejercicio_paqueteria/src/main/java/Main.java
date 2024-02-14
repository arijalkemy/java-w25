public class Main {
    public static void main(String[] args) {
        double sueldoBase = 21000; //monto de ejemplo
        String dni = "12345678"; //dni de ejemplo
        double sueldoConAumento;

        int primeraCategoria = 45000;
        int segundaCategoria = 20000;

        if (sueldoBase <= segundaCategoria) {
            sueldoConAumento = sueldoBase * 120;
        }
        else {
            if (sueldoBase <= primeraCategoria){
                sueldoConAumento = sueldoBase * 1.10;
            }
            else {
                sueldoConAumento = sueldoBase * 1.10;
            }
        }

        System.out.println("El nuevo sueldo del empleado es de: " + sueldoConAumento);
    }
}
