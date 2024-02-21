public class App {
    public static void main(String[] args) throws Exception {
        Integer SUELDO_PISO=20000;
        Integer SUELDO_TECHO=45000;
        double sueldoBase = 21000;
        String dni = "12345678";
        double sueldoConAumento=0;

        if(sueldoBase<=SUELDO_PISO) {
            sueldoConAumento = sueldoBase+((sueldoBase*20)/100);
        }
        else {
            if(sueldoBase<SUELDO_TECHO){
                sueldoConAumento = sueldoBase+((sueldoBase*10)/100);
            }
            else {
                sueldoConAumento = sueldoBase+((sueldoBase*5)/100);
            }
        }

        System.out.println ("El nuevo sueldo del empleado con dni \""+dni+"\" es de: " + sueldoConAumento);
    }
}
