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

        Inscribir(1, chico, darwin);
        Inscribir(2, chico, natalia);
        //-----------------------------------------------------------------------------------------|OUT|
        MostrarInscritos(Categorias.chico);
        Desinscribir(1);
    }
}