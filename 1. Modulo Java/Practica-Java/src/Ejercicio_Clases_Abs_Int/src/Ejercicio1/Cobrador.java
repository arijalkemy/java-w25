package Ejercicio_Clases_Abs_Int.src.Ejercicio1;

public class Cobrador extends Cliente {
    private RetiroEnEfectivo retiro;
    private ConsultaDeSaldo consulta;

    public Cobrador(String nombre, RetiroEnEfectivo retiro, ConsultaDeSaldo consulta) {
        super(nombre);
        this.retiro = retiro;
        this.consulta = consulta;
    }

    public void retirarSaldo() {
        retiro.transaccionOk();
    }

    public void consultarSaldo() {
        consulta.transaccionOk();
    }
}
