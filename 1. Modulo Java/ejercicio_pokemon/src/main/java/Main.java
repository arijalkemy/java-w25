import entity.Bulbasaur;
import entity.Charmander;
import entity.Pikachu;
import entity.Squirtle;

public class Main {
    public static void main(String[] args) {
        Squirtle squirtle=new Squirtle();
        Charmander charmander=new Charmander();
        Pikachu pikachu=new Pikachu();
        Bulbasaur bulbasaur=new Bulbasaur();

        squirtle.attackTackle();
        squirtle.attackHidrobomba();
        charmander.attackTackle();
        charmander.attackLanzallamas();
        bulbasaur.attackTackle();
        bulbasaur.attackDrenaje();
        pikachu.attackTackle();
        pikachu.attackImpacTrueno();

    }
}
