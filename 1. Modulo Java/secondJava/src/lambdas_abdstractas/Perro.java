package lambdas_abdstractas;

public class Perro extends Animal implements ICarnivoro{
    @Override
    public void makeSound() {
        System.out.println("Guau");
    }

    @Override
    public void comerCarne() {
        this.setSalud(2);
        System.out.println("El perro esta comiendo carne");
        System.out.println("Salud: " + this.getSalud());
    }
}
