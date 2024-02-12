package Dakar;

import Dakar.socorristas.SocorristaCarro;
import Dakar.socorristas.SocorristaMoto;

public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(1.5,30000,"La Carrera ",10);
        Vehiculo moto = new SocorristaMoto(3000,500,180,"LX58A");
        Vehiculo moto1 = new Moto(3000,500,180,"LX58B");
        Vehiculo moto2 = new Moto(3000,500,180,"LX58C");
        Vehiculo moto3 = new SocorristaMoto(3000,500,180,"LX58D");
        Vehiculo carro = new Carro(3000,500,180,"AX58C");
        Vehiculo carro1 = new Carro(3000,500,180,"BX58C");
        Vehiculo carro2 = new Carro(3000,500,180,"CX58C");
        Vehiculo carro3 = new SocorristaCarro(3000,500,180,"DX58C");
        carrera.darDeAltaVehiculo(moto );
        carrera.darDeAltaVehiculo(moto1);
        carrera.darDeAltaVehiculo(moto2);
        carrera.darDeAltaVehiculo(moto3);
        carrera.darDeAltaVehiculo(carro1);
        carrera.darDeAltaVehiculo(carro2);
        carrera.darDeAltaVehiculo(carro3);
        carrera.darDeAltaVehiculo(carro);
        carrera.definirGanadosCarrera();
        carrera.imprimirLista();
        carrera.socorrerMoto(moto1.getPatente());
        carrera.socorrerCarro(carro2.getPatente());
        carrera.socorrerCarro(carro3.getPatente());


    }
}
