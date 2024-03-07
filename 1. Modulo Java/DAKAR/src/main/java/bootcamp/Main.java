package bootcamp;

public class Main {
    public static void main(String[] args) {

        Auto auto1 =  new Auto(50.0,1.2,5.0,"abc123");
        Moto moto1 = new Moto(100.0, 2.0,16.0,"erc234");
        SocorristaAuto socoAuto = new SocorristaAuto();
        SocorristaMoto socorristaMoto = new SocorristaMoto();
        Carrera carrera = new Carrera(1500.0, 1500.0, "Carrera1", 2, socoAuto, socorristaMoto );
        carrera.altaAuto(50.0,1.2,5.0,"abc123");
        carrera.altaMoto(100.0, 2.0,16.0,"erc234");
        System.out.println("El ganador es: " + carrera.calcularGanador());
        carrera.socorrerAuto("abc123");
        carrera.socorrerMoto("erc234");


    }
}