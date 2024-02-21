//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        double sueldoBase = 45000; // monto de ejemplo
        String dni = "12345678"; // dni de ejemplo
        double sueldoConAumento;

        if (sueldoBase <= 20000) {
            sueldoConAumento = sueldoBase + (sueldoBase * (20.0 / 100.0)); // división decimal
            System.out.println("El nuevo sueldo del empleado es de: " + sueldoConAumento);
        }
        else if (sueldoBase >= 20000 || sueldoBase <= 45000){
                sueldoConAumento = sueldoBase + (sueldoBase * (10.0 / 100.0)); // división decimal
            System.out.println("El nuevo sueldo del empleado es de: " + sueldoConAumento);
            }
        else if (sueldoBase >= 45000){
            sueldoConAumento = sueldoBase + (sueldoBase * (5.0 / 100.0)); // división decimal
            System.out.println("El nuevo sueldo del empleado es de: " + sueldoConAumento);
        }




    }
}