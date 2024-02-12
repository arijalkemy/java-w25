import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Categoria categoriaChico = new Categoria(
                1, "chico", "2 km por selva y arroyos"
        );
        Categoria categoriaMedio = new Categoria(
                2, "medio", "5 km por selva, arroyos y barro"
        );
        Categoria categoriaAvanzado = new Categoria(
                3, "avanzado", "10 km por selva, arroyos, barro y escalada en piedra"
        );

        Participante participante1 = new Participante(1, 1, "Juan", "Tamayo", 15, "111111", "111111", "O+");
        Inscripcion inscripcion1 = new Inscripcion(1, categoriaChico, participante1);


    }
}