package OpcionesBancarias;

public class Deposito implements ITransaccion{
    @Override
    public void trasaccionOk() {
        System.out.println("Se ha hecho el deposito correctamente");
    }
}
