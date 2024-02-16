public abstract class Cliente implements ITransaction{

    String nombre;
    String tipoCliente;

    public Cliente(String nombre, String tipoCliente) {
        this.nombre = nombre;
        this.tipoCliente = tipoCliente;
    }

    @Override
    public void transaccionOk(String metodo) {
        System.out.println(metodo + " OK");
    }

    @Override
    public void transaccionNoOk(String metodo) {
        System.out.println(metodo + " No OK");
    }

    public abstract void movimiento(String movimiento);

}
