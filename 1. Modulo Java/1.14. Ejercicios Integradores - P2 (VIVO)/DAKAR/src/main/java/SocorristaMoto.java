public class SocorristaMoto implements VehiculoSocorrista<Moto> {
    public void socorrer(Moto moto) {
        System.out.println("Socorriendo moto " + moto.getPatente());
    }
}
