package entity;

public class Squirtle extends Pokemon implements IWater{
    public Squirtle() {
    }

    @Override
    public void attackTackle() {
        System.out.println("Hola soy Squirtle, ataque placaje");
    }

    @Override
    protected void attackScratch() {
        System.out.println("Hola soy Squirtle, ataque aranazo");
    }

    @Override
    protected void attackNibble() {
        System.out.println("Hola soy Squirtle, ataque mordisco");
    }

    @Override
    public void attackHidrobomba() {
        System.out.println("Hola soy Squirtle, ataque hidrobomba");
    }

    @Override
    public void attackBurbuja() {
        System.out.println("Hola soy Squirtle, ataque burbuja");
    }

    @Override
    public void attackPistolaAgua() {
        System.out.println("Hola soy Squirtle, ataque pistola agua");
    }
}
