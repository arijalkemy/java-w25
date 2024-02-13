package dakar;

public class SocorristaMoto implements Socorrista<Moto>{

    @Override
    public void socorrer(Moto moto) {
        System.out.printf("Socorriendo auto con patente %s", moto.getPatente());
    }
}
