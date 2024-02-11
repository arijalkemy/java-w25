package bootcamp;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Serie<Integer> s3 = new Serie3<>();
        Serie<Double> s2 = new Serie2<>();
        s2.setValorInicial(1.0);
        System.out.println(s2.siguienteValor());
        System.out.println(s2.siguienteValor());
        s2.reiniciar();
        System.out.println(s2.siguienteValor());
        System.out.println(s3.siguienteValor());
        System.out.println(s3.siguienteValor());


    }
}