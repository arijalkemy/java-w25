public class Dog extends Animal implements Carnivorous{
    @Override
    public void emitSound() {
        System.out.println("Guau");
    }

    @Override
    public void eatMeat() {
        System.out.println("El perro come carne");
    }
}
