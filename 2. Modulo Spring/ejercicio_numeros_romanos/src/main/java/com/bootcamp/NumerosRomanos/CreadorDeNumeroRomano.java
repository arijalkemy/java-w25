package com.bootcamp.NumerosRomanos;

import java.util.List;

public class CreadorDeNumeroRomano {
    private StringBuilder numeroRomano;
    private int numeroDecimal;


    public CreadorDeNumeroRomano(int numeroDecimal) {
        this.numeroDecimal = numeroDecimal;
        this.numeroRomano = new StringBuilder();

    }
    private void calcularCantidadRomana(String letra, int valorRomano){
        int cantidadNumero = numeroDecimal / valorRomano;
        numeroDecimal -= cantidadNumero * valorRomano;
        numeroRomano.append(letra.repeat(cantidadNumero));
    }
    public String crearNumeroRomano(){
        String[] numerosRomanos = {"M", "CM", "D", "CD", "C","XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int[] valoresRomanos = {1000, 900, 500,400,100,90,50,40,10,9,5,4,1};
        for(int i = 0; i< numerosRomanos.length; i++){
            calcularCantidadRomana(numerosRomanos[i], valoresRomanos[i]);
        }
        return this.numeroRomano.toString();
    }
}
