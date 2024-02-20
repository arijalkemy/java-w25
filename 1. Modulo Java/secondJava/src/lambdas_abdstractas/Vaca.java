package lambdas_abdstractas;

public class Vaca extends Animal implements IHerbivoro{
    @Override
    public void makeSound() {
        System.out.println("Muu");
    }

    @Override
    public void comerHierba() {
        this.setSalud(1);
        System.out.println("La vaca esta comiendo hierba");
        System.out.println("Salud: " + this.getSalud());
    }
}
