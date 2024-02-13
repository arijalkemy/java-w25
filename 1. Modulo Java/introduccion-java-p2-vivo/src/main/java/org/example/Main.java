package org.example;

import org.example.models.Circuito;
import org.example.models.Participante;
import org.example.service.RealizarInscripcion;

import static org.example.service.RealizarInscripcion.*;

public class Main {
    public static void main(String[] args) {
        //-----------------------------------------------------------------------------------------|VARS|
        Circuito chico = new Circuito(1,"chico","2km por selva y arroyos");
        Circuito medio = new Circuito(2,"medio","5km poer selva, arroyos y barro");
        Circuito avanzado = new Circuito(3,"avanzado","10km poer selva, arroyos, barro y escalada en piedra");

        //-----------------------------------------------------------------------------------------|PROCESS|
        Participante darwin = new Participante(1,100034344,"Darwin", "Nuñez", 20, "3117283040", "3118389434", Participante.GrupoSanguineo.A);
        Participante natalia = new Participante(2,100024545,"Natalia", "Natalia", 19, "313143440", "3113324344", Participante.GrupoSanguineo.B);
        Participante laura = new Participante(3,100345664,"Laura", "Tuquerrez", 34, "387273766", "939573755", Participante.GrupoSanguineo.O);
        Participante john = new Participante(4,102938883,"John", "Espinoza", 16, "39483293", "727482777", Participante.GrupoSanguineo.AB);

        Inscribir(1, chico, darwin);//registro a circuito chico
        Inscribir(2, chico, darwin);//no registar 2 veces
        Inscribir(3, medio, natalia);//registro a circuito medio
        Inscribir(4, avanzado, laura);//registro a circuito avanzado
        Inscribir(5, avanzado, john);//registro invalido por edad
        //-----------------------------------------------------------------------------------------|OUT|
        MostrarInscritos(Categorias.chico);
        Desinscribir(1);
        Desinscribir(10);//Desinscribir uno que no existe
        MostrarRecaudacion();
    }
}