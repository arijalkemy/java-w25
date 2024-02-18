package dakar;

public class SocorristaAuto implements Socorrista<Auto> {

    @Override
    public void socorrer(Auto auto) {
        System.out.printf("Socorriendo auto con patente %s", auto.getPatente());
    }
}
