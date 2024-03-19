package main;



public abstract class Cliente {

    private String name;
    private String dni;
    private int saldo;
    private String numeroCuenta;

    public Cliente(String name, String dni, int saldo, String numeroCuenta) {
        this.name = name;
        this.dni = dni;
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public abstract void consultarSaldo();
    public abstract void pagarServicios();
    public abstract void retirarEfectivo();
    public abstract void transferir();
    public abstract void depositar();


}
