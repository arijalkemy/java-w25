public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona();
        Persona p2 = new Persona("Tobias", 22, "12122122");
        Persona p3 = new Persona("Juan", 28, "11133133", 83.5, 1.85);
        int imc = p3.calcularIMC();
        System.out.println(p3.toString());
        System.out.println("Calculando IMC");
        if(imc == -1){
            System.out.println("Bajo de peso");}
        else {
            if(imc == 0){
                System.out.println("Peso saludable");
            }
            else{
                System.out.println("Sobrepeso");
            }
        }
        boolean mayor = p3.esMayorDeEdad();
        if (mayor) {
            System.out.println("Es mayor de edad");
        }else{
            System.out.println("Es menor de edad");
        }


    }
}