public class Main {
    public static void main(String[] args) {
        Perecedero perecedero1 = new Perecedero("perecedero1", 120, 1);
        Perecedero perecedero2 = new Perecedero("perecedero2", 90, 2);
        Perecedero perecedero3 = new Perecedero("perecedero3", 83, 3);
        Perecedero perecedero4 = new Perecedero("perecedero4", 35, 4);
        Perecedero perecedero5 = new Perecedero("perecedero5", 61, 5);

        NoPerecedero noPerecedero1 = new NoPerecedero("noPerecedero1", 25, "1");
        NoPerecedero noPerecedero3 = new NoPerecedero("noPerecedero2", 33, "2");
        NoPerecedero noPerecedero4 = new NoPerecedero("noPerecedero3", 95, "3");
        NoPerecedero noPerecedero2 = new NoPerecedero("noPerecedero4", 17, "4");
        NoPerecedero noPerecedero5 = new NoPerecedero("noPerecedero5", 100, "5");

        Distribuidora distribuidora = new Distribuidora();

        distribuidora.agregarProducto(perecedero1);
        distribuidora.agregarProducto(perecedero2);
        distribuidora.agregarProducto(perecedero3);
        distribuidora.agregarProducto(perecedero4);
        distribuidora.agregarProducto(perecedero5);
        distribuidora.agregarProducto(noPerecedero1);
        distribuidora.agregarProducto(noPerecedero2);
        distribuidora.agregarProducto(noPerecedero3);
        distribuidora.agregarProducto(noPerecedero4);
        distribuidora.agregarProducto(noPerecedero5);

        System.out.println("\n----------------------------");
        perecedero1.calcular(1);

        System.out.println("\n----------------------------");
        System.out.println("Calcular el precio total de los 5 productos de cada tipo:");
        distribuidora.calcularPrecioTotal();

    }
}
