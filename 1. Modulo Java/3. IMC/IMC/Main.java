public class Main {
    public static void main(String[] args) {
        Persona personaConstructorVacio = new Persona();
        Persona personaConstructorParcial = new Persona(
                "julian",
                21,
                "1000"
        );
        Persona personaConstructorCompleto = new Persona(
                "Julian",
                21,
                "1000",
                75.0,
                1.87
        );

        if(personaConstructorCompleto.esMayorDeEdad()){
            System.out.printf("La persona llamada %s es mayor de edad.\n", personaConstructorCompleto.getNombre());
        } else {
            System.out.printf("La persona llamada %s es menor de edad.\n", personaConstructorCompleto.getNombre());
        }

        String estado;
        switch(personaConstructorCompleto.calcularIMC()) {
            case -1 -> {
                estado = "Bajo peso";
            }
            case 0 -> {
                estado = "Peso saludable";
            }
            case 1 -> {
                estado = "Sobrepeso";
            }
            default -> {
                estado = "Desconocido";
            }
        }

        System.out.printf("Esta persona tiene un estado %s.\n", estado);
        System.out.printf("Info: %s", personaConstructorCompleto.toString());
    }
}
