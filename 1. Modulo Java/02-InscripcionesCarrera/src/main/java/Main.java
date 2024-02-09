import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Categoria> categorias = new ArrayList<>();
        categorias.add(new Categoria(1,"Circuito chico",2,"Selva y arroyos"));
        categorias.add(new Categoria(2,"Circuito medio",5,"Selva,arroyos y barro"));
        categorias.add(new Categoria(3,"Circuito avanzado",10,"Selva,arroyos,barro y escalada en priedra"));

        Participante participante1 = new Participante(1,666666,"Pepito", "Perez",23,123456,654321,"A");

        Participante participante2 = new Participante(2,77777,"juanito", "Perez",18,123456,654321,"O+");

        Participante participante3 = new Participante(3,88888,"carlitos", "Perez",17,123456,654321,"O-");



        Inscripcion inscripcion = new Inscripcion(1,categorias.get(1),participante1);
        Inscripcion inscripcion2 = new Inscripcion(2,categorias.get(2),participante2);
        Inscripcion inscripcion3 = new Inscripcion(3,categorias.get(1),participante3);

        inscripcion.calcularMonto();
        System.out.println("monto a pagar: "+inscripcion.getMonto());



    }
}
