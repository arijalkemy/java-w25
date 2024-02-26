import org.example.Categoria;
import org.example.Inscripcion;
import org.example.Participante;

public class Main {
    public static void inscribir(Categoria categoria, Participante participante, Inscripcion inscripcion){
        if (participante.getEdad() >= 18){
            if (categoria.getNombre().equals("Circuito chico")){
                inscripcion.setCategoria(categoria);
                inscripcion.setMonto(1500);
                inscripcion.setParticipante(participante);
            }else if (categoria.getNombre().equals("Circuito medio")){
                inscripcion.setCategoria(categoria);
                inscripcion.setMonto(2300);
                inscripcion.setParticipante(participante);
            }else{
                inscripcion.setCategoria(categoria);
                inscripcion.setMonto(2800);
                inscripcion.setParticipante(participante);
            }
        }else{
            if (categoria.getNombre().equals("Circuito chico")){
                inscripcion.setCategoria(categoria);
                inscripcion.setMonto(1300);
                inscripcion.setParticipante(participante);
            }else if (categoria.getNombre().equals("Circuito medio")){
                inscripcion.setCategoria(categoria);
                inscripcion.setMonto(2000);
                inscripcion.setParticipante(participante);
            }else{
                inscripcion.remove();
                System.out.println("La persona fue rechazada por no cumplir la restriccion");
            }
        }
    }




    public static void main(String[] args) {
        Categoria chico = new Categoria("Circuito chico",
                "Menores de 18 años $1300. Mayores de 18 años $1500.");
        Categoria medio = new Categoria("Circuito medio",
                "Menores de 18 años $2000. Mayores de 18 años $2300.");
        Categoria avanzado = new Categoria("Circuito avanzado",
                "No se permite inscripciones a menores de 18 años. Mayores de 18 años $2800.");
        Participante p1 = new Participante("302932049","Andres","Villamizar",
                20,"2393932", "39482349","o+");
        Participante p2 = new Participante("302932049","Andres","Villamizar",
                17,"2393932", "39482349","o+");
        Participante p3 = new Participante("302932049","Andres","Villamizar",
                21,"2393932", "39482349","o+");

        Main.inscribir(avanzado, p1, new Inscripcion());
        Main.inscribir(avanzado, p2, new Inscripcion());
        Main.inscribir(medio, p2, new Inscripcion());
        Main.inscribir(chico, p2, new Inscripcion());
        Main.inscribir(medio, p3, new Inscripcion());
        Main.inscribir(chico, p1, new Inscripcion());
        System.out.println(Inscripcion.totalRecaudado());
        Inscripcion.mostrarCategoria("Circuito chico");
    }
}