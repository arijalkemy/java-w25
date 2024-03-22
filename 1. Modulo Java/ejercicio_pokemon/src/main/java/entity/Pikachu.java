package entity;

public class Pikachu extends Pokemon implements IElectric{
    public Pikachu() {
    }

    @Override
    public void attackTackle() {
        System.out.println("Hola soy Pikachu, ataque placaje");
    }

    @Override
    protected void attackScratch() {
        System.out.println("Hola soy Pikachu, ataque aranazo");
    }

    @Override
    protected void attackNibble() {
        System.out.println("Hola soy Pikachu, ataque mordisco");
    }

    @Override
    public void attackImpacTrueno() {
        System.out.println("Hola soy Pikachu, ataque trueno");
    }

    @Override
    public void attackPunioTrueno() {
        System.out.println("Hola soy Pikachu, ataque punio trueno");
    }
}
