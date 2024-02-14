package classes;

import interfaces.*;

public class Cobrador {
    private String nombreCompleto;
    private RetiroEfectivo retiroEfectivo;
    private ConsultaSaldo consultaSaldo;

    public Cobrador(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
        this.retiroEfectivo = new RetiroEfectivo();
        this.consultaSaldo = new ConsultaSaldo();
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public RetiroEfectivo getRetiroEfectivo() {
        return retiroEfectivo;
    }

    public ConsultaSaldo getConsultaSaldo() {
        return consultaSaldo;
    }

}
