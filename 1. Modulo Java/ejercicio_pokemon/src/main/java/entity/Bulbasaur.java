package entity;

public class Bulbasaur extends Pokemon implements IPlant{
    public Bulbasaur() {
    }

    @Override
    public void attackTackle() {
        System.out.println("Hola soy Bulbasaur, ataque placaje");
    }

    @Override
    protected void attackScratch() {
        System.out.println("Hola soy Bulbasaur, ataque aranazo");
    }

    @Override
    protected void attackNibble() {
        System.out.println("Hola soy Bulbasaur, ataque mordisco");
    }

    @Override
    public void attackDrenaje() {
        System.out.println("Hola soy Bulbasaur, ataque drenaje");
    }

    @Override
    public void attackParalizar() {
        System.out.println("Hola soy Bulbasaur, ataque paralizar");
    }
}
