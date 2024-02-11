package org.example;

public class Ejecutivo extends Cliente implements IDeposito, ITransferencia{

    @Override
    public void depositar(){
        System.out.println("Depositando efectivo");
    };

    @Override
    public void transferir(){
        System.out.println("Efectivo transferido a CBU:xxxxxxxxxxxxxxxxx");
    };

}
