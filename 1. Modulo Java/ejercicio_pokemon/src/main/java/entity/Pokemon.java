package entity;

public abstract class Pokemon {
    protected Integer numPokedex;
    protected String namePokemon;
    protected Double weight;
    protected String genre;
    protected Integer season;

    // Abstract methods
    protected abstract void attackTackle();
    protected abstract void attackScratch();
    protected abstract void attackNibble();
}
