package integracion.p1.series;

public class Main {
    public static void main(String[] args) {
        Serie2 serie2 = new Serie2();
        Serie5 serie5 = new Serie5();

        System.out.println("serie2.getNextValue() = " + serie2.getNextValue());
        System.out.println("serie2.getNextValue() = " + serie2.getNextValue());
        System.out.println("serie2.getNextValue() = " + serie2.getNextValue());
        serie5.setInitialValue(9);
        System.out.println("serie5 = " + serie5.getNextValue());
        System.out.println("serie5 = " + serie5.getNextValue());
        System.out.println("serie5 = " + serie5.getNextValue());
        serie5.restartSerie();
        System.out.println("serie5 = " + serie5.getNextValue());
        System.out.println("serie5 = " + serie5.getNextValue());

    }
}
