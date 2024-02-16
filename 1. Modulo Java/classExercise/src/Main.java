public class Main {
    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person("Horacio", 30, "104567");
        Person person3 = new Person(1, "Juan", 23, "124344", 45.0, 178.0);

        if (person3.isUpperAge()) {
            System.out.println("Es mayor de edad");
        } else {
            System.out.println("Es menor de edad");
        }
        System.out.println(person3);

        int IMC = person3.CalculateIMC();

        if (IMC == -1) {
            System.out.println("Bajo peso");
        } else if (IMC == 0) {
            System.out.println("Peso saludable");
        } else {
            System.out.println("Sobrepeso");
        }
    }
}