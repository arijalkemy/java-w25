package lambdas_abdstractas;

public class Gato extends Animal implements ICarnivoro{
    @Override
    public void makeSound() {
        System.out.println("Miau");
    }

    @Override
    public void comerCarne() {
        this.setSalud(2);
        System.out.println("El gato esta comiendo carne");
        System.out.println("Salud: " + this.getSalud());
    }
}
