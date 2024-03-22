package entity;

public class Charmander extends Pokemon implements IFire{
    public Charmander() {
    }

    @Override
    public void attackTackle() {
        System.out.println("Hola soy Charmander, ataque placaje");
    }

    @Override
    protected void attackScratch() {
        System.out.println("Hola soy Charmander, ataque aranazo");
    }

    @Override
    protected void attackNibble() {
        System.out.println("Hola soy Charmander, ataque mordisco");
    }

    @Override
    public void attackPunioFuego() {
        System.out.println("Hola soy Charmander, ataque punio fuego");
    }

    @Override
    public void attackLanzallamas() {
        System.out.println("Hola soy Charmander, ataque lanzallamas");
    }

    @Override
    public void attackAscuas() {
        System.out.println("Hola soy Charmander, ataque ascuas");
    }
}
