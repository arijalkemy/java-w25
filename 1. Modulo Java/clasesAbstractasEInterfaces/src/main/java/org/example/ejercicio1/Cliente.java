package org.example.ejercicio1;

import java.util.List;

public abstract class Cliente {
    private List<Itransaccion> listaTransaccion;

    public Cliente(List<Itransaccion> listaTransaccion) {
        this.listaTransaccion = listaTransaccion;
    }

    public List<Itransaccion> getListaTransaccion() {
        return listaTransaccion;
    }

    public void setListaTransaccion(List<Itransaccion> listaTransaccion) {
        this.listaTransaccion = listaTransaccion;
    }

    public <T extends Itransaccion> void hacerTransaccionOK(T transaccion){
        transaccion.transaccionOK();
    }
    public <T extends Itransaccion> void hacerTransaccionNoOK(T transaccion){
        transaccion.transaccionNoOK();
    }
}
