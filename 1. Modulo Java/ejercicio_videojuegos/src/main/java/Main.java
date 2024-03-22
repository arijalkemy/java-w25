import logic.Videojuego;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Videojuego> listaVideojuegos = new ArrayList<>();

        Videojuego videojuego1 = new Videojuego(001, "League of Legends", "PC", 10, "MORGP");
        Videojuego videojuego2 = new Videojuego(002, "WOW", "PC", 20, "MORGP");
        Videojuego videojuego3 = new Videojuego(003, "FIFA", "Consola", 2, "Deportes");
        Videojuego videojuego4 = new Videojuego(004, "PES", "Consola", 2, "Deportes");
        Videojuego videojuego5 = new Videojuego(005, "Hearthsone", "PC", 1, "Cartas");

        listaVideojuegos.add(videojuego1);
        listaVideojuegos.add(videojuego2);
        listaVideojuegos.add(videojuego3);
        listaVideojuegos.add(videojuego4);
        listaVideojuegos.add(videojuego5);

        // Recorriendo lista
        for (Videojuego videojuego : listaVideojuegos) {
            System.out.println("Titulo: " + videojuego.getTitulo() + " Consola: " + videojuego.getConsola() + " Players: " + videojuego.getPlayers());
        }

        // Modificando elemento
        videojuego1.setTitulo("LOL");
        videojuego1.setPlayers(5);
        videojuego5.setTitulo("HS");
        videojuego5.setPlayers(8);

        // Listar solo los videojuegos de PC
        for(Videojuego videojuego: listaVideojuegos){
            if(videojuego.getConsola().equals("PC")){
                System.out.println(videojuego.toString());
            }
        }
    }
}
