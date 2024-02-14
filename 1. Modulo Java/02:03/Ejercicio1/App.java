import classes.*;

public class App {
    public static void main(String[] args) throws Exception{
        Ejecutivo ejecutivo1 = new Ejecutivo("Ejecutivo Uno");
        ejecutivo1.getTransferencia().transaccionOk();
        ejecutivo1.getTransferencia().transaccionNoOk();
        ejecutivo1.getDeposito().transaccionOk();
        ejecutivo1.getDeposito().transaccionNoOk();

        Cobrador cobrador1 = new Cobrador("Cobrador Uno");
        cobrador1.getConsultaSaldo().transaccionOk();
        cobrador1.getConsultaSaldo().transaccionNoOk();
        cobrador1.getRetiroEfectivo().transaccionOk();
        cobrador1.getRetiroEfectivo().transaccionNoOk();
    }
}
