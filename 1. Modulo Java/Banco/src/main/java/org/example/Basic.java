package org.example;

public class Basic extends Cliente{
    public Basic(String nombre, double saldo) {
        super(nombre, saldo);
    }

    public void consultarSaldo(){
        System.out.println("Su saldo es: $" + getSaldo());
    }

    public void pagosServicios(){
        System.out.println("Pagar servicios");
    }

    public void retirarEfectivo(double efectivoPorRetirar){
        System.out.println("Retirando dinero...");
        if (this.getSaldo() > efectivoPorRetirar)
            setSaldo(this.getSaldo() - efectivoPorRetirar);
        else
            System.out.println("No hay tanto dinero en tu cuenta");
    }
}
