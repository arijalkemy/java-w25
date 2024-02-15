public class Person {
    String name;
    int age;
    String dni;
    double weight;
    double height;

    public Person() {};

    public Person(String name, int age, String dni) {
        this.name = name;
        this.age = age;
        this.dni = dni;
    };

    public Person(String name, int age, String dni, double weight, double height) {
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.weight = weight;
        this.height = height;
    }

    public int calculateIMC() {
        double num = this.weight;
        double denom = Math.pow(this.height, 2);
        double imc = num / denom;

        if(imc < 20) {
            return -1;
        }

        if(imc >= 20 && imc <= 25) {
            return 0;
        }

        return 1;
    }

    public boolean isAdult() {
        return this.age >= 18;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + name + '\'' +
                ", edad=" + age +
                ", dni='" + dni + '\'' +
                ", peso=" + weight +
                ", altura=" + height +
                '}';
    }
}
