package com.main;

public class SerieProgresiva1 extends Prototipo<Integer>{
    private int numeroInicial;
    private int serie;

    @Override
    public Integer siguienteNumero() {
        int temp =this.serie;
        this.serie+=this.numeroInicial;
        return temp;
    }

    @Override
    public void reiniciarSerie() {

        this.establecerValorInicial(this.numeroInicial);
    }

    @Override
    public void establecerValorInicial(Integer numero) {
        this.numeroInicial=numero;
        this.serie= numero;

    }
}
