public class SocorristaAuto implements VehiculoSocorrista<Auto> {
    public void socorrer(Auto auto) {
        System.out.println("Socorriendo auto " + auto.getPatente());
    }
}
