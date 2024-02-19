package com.main;

public class SerieProgresiva2 extends Prototipo<Float>{
    private float numeroInicial;
    private float serie;

    @Override
    public Float siguienteNumero() {
        float temp =this.serie;
        this.serie+=2;
        return temp;
    }

    @Override
    public void reiniciarSerie() {
        this.establecerValorInicial(this.numeroInicial);
    }

    @Override
    public void establecerValorInicial(Float numero) {
        this.numeroInicial=numero;
        this.serie= numero+2;

    }
}
