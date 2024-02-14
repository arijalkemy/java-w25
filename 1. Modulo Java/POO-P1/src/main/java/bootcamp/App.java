package bootcamp;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Libro libro = new Libro("Harry Potter", "J. K. Rowling", 20);
        System.out.println(libro.mostrarLibro());
        System.out.println("La cantidad de ejemplares para este libro es de: " + libro.cantidadDeEjemplares());
        Automovil auto = new Automovil("Ford Fiesta", "Rojo", 60000);
        System.out.println(auto.mostrarMarcaYColor());
    }
}
