package Ejercicio_Clases_Abs_Int.src.Ejercicio1;

public class Basic extends Cliente {

    private RetiroEnEfectivo retiroEnEfectivo;
    private ConsultaDeSaldo consultaDeSaldo;
    private PagoDeServicios pagoServicios;

    public Basic(String nombre, RetiroEnEfectivo retiroEnEfectivo, ConsultaDeSaldo consultaDeSaldo, PagoDeServicios pagoServicios) {
        super(nombre);
        this.retiroEnEfectivo = retiroEnEfectivo;
        this.consultaDeSaldo = consultaDeSaldo;
        this.pagoServicios = pagoServicios;
    }

    public void retirarEfectivo() {
        retiroEnEfectivo.transaccionOk();
    }

    public void consultarSaldo() {
        consultaDeSaldo.transaccionOk();
    }

    public void pagarServicios() {
        pagoServicios.transaccionOk();
    }
}
