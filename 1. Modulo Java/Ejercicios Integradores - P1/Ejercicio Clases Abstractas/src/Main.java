/*
Se desea crear al menos 2 clases que extiendan de una clase prototipo, que genera un valor en función,
a una serie progresiva. La clase prototipo contendrá tres métodos. El primero de los métodos es el encargado
de devolver un número que corresponderá al valor siguiente a la serie progresiva. Otro método para reiniciar
la serie, y un último que recibirá un valor que servirá para establecer el valor inicial de la serie.
Las clases deben estar preparadas para recibir cualquier tipo de dato numérico no primitivo.
*/

public class Main {
    public static void main(String[] args) {
        System.out.println("Se crea una serie de 2");
        SeriesByTwo seriesByTwo = new SeriesByTwo();
        System.out.println("Primera Vez: " + seriesByTwo.genNextValue());
        System.out.println("Segunda Vez: " + seriesByTwo.genNextValue());
        System.out.println("Tercera Vez: " + seriesByTwo.genNextValue());
        System.out.println("Cuarta Vez: " + seriesByTwo.genNextValue());
        System.out.println();

        System.out.println("Se crea una serie de 2 con valor inicial 1");
        SeriesByTwo seriesByTwoW1 = new SeriesByTwo(1);
        System.out.println("Primera Vez: " + seriesByTwoW1.genNextValue());
        System.out.println("Segunda Vez: " + seriesByTwoW1.genNextValue());
        System.out.println("Tercera Vez: " + seriesByTwoW1.genNextValue());
        System.out.println("Cuarta Vez: " + seriesByTwoW1.genNextValue());
        System.out.println();

        System.out.println("Se crea una serie de 3");
        SeriesByThree seriesByThree = new SeriesByThree();
        System.out.println("Primera Vez: " + seriesByThree.genNextValue());
        System.out.println("Segunda Vez: " + seriesByThree.genNextValue());
        System.out.println("Tercera Vez: " + seriesByThree.genNextValue());
        System.out.println("Cuarta Vez: " + seriesByThree.genNextValue());

    }
}