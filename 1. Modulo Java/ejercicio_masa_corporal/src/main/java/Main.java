import entity.Person;

public class Main {
    public static void main(String[] args) {
        Person emptyPerson = new Person();
        Person halfPerson = new Person("Jack", 54, "1212341234");
        Person fullPerson = new Person("Bruce", 35, "1212341234", 55.6, 1.85);

        // Person brokenPerson = new Person("Lucas", 30);
        if (fullPerson.isOlder()) {
            System.out.println("Es mayor de edad");
        }

        var imc = fullPerson.calculateIMC();

        switch (imc) {
            case -1:
                System.out.println("Bajo peso");
                break;
            case 0:
                System.out.println("Peso saludable");
                break;
            case 1:
                System.out.println("Sobrepeso");
                break;

        }

        System.out.println(fullPerson);

    }
}
