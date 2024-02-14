package OpcionesBancarias;

public interface ITransaccion {
    void trasaccionOk();
    static void transaccionNoOk() {
        System.out.println("La operación no se ha podido completar.");
    };
}
