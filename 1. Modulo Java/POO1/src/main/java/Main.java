public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Juan", 15, "12345678");
        Persona persona3 = new Persona("Maria", 20, "1111111", 77, 1.76);


        int imc = persona3.calcularIMC();
        String imcMessage;
        switch (imc){
            case -1:{
                imcMessage = "Bajo peso";
                break;
            }
            case 0:{
                imcMessage = "Peso saludable";
                break;
            }
            default:{
                imcMessage = "Sobrepeso";
                break;
            }

        }
        System.out.println("IMC: "+imcMessage);

        boolean mayorEdad = persona3.esMayorDeEdad();
        System.out.println("Mayor de edad: "+ mayorEdad);

        System.out.println(persona3.toString());

    }
}
