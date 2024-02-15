public class Cow extends Animal implements Herbivorous {
    @Override
    public void eatGrass() {
        System.out.println("La vaca come hierba");
    }

    @Override
    public void emitSound() {
        System.out.println("Muuu");
    }
}
