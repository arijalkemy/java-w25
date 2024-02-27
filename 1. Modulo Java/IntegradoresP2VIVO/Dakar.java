package IntegradoresP2VIVO;

import java.util.ArrayList;
import java.util.List;

public class Dakar {
    public static void main(String[] args) {
        // Ejemplo de uso
        Carrera carrera = new Carrera(1000, 5000, "Gran Carrera", 10);

        carrera.darDeAltaAuto(200, 10, 30, "ABC123");
        carrera.darDeAltaMoto(150, 8, 25, "XYZ456");

        Vehiculo ganador = carrera.definirGanador();
        System.out.println("El ganador es el vehículo con patente: " + ganador.patente);

        carrera.socorrerAuto("ABC123");
        carrera.socorrerMoto("XYZ456");
    }
}


// Clase Vehiculo
class Vehiculo {
    double velocidad;
    double aceleracion;
    double anguloDeGiro;
    String patente;
    double peso;
    int ruedas;
}

// Clase Auto que hereda de Vehiculo
class Auto extends Vehiculo {
    public Auto() {
        peso = 1000;
        ruedas = 4;
    }
}

// Clase Moto que hereda de Vehiculo
class Moto extends Vehiculo {
    public Moto() {
        peso = 300;
        ruedas = 2;
    }
}

// Clase Carrera
class Carrera {
    double distancia;
    double premioEnDolares;
    String nombre;
    int cantidadDeVehiculosPermitidos;
    List<Vehiculo> listaDeVehiculos;
    SocorristaAuto socorristaAuto;
    SocorristaMoto socorristaMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        listaDeVehiculos = new ArrayList<>();
        socorristaAuto = new SocorristaAuto();
        socorristaMoto = new SocorristaMoto();
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos) {
            Auto auto = new Auto();
            auto.velocidad = velocidad;
            auto.aceleracion = aceleracion;
            auto.anguloDeGiro = anguloDeGiro;
            auto.patente = patente;
            listaDeVehiculos.add(auto);
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos) {
            Moto moto = new Moto();
            moto.velocidad = velocidad;
            moto.aceleracion = aceleracion;
            moto.anguloDeGiro = anguloDeGiro;
            moto.patente = patente;
            listaDeVehiculos.add(moto);
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        listaDeVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        for (Vehiculo vehiculo : listaDeVehiculos) {
            if (vehiculo.patente.equals(unaPatente)) {
                listaDeVehiculos.remove(vehiculo);
                break;
            }
        }
    }

    public Vehiculo definirGanador() {
        Vehiculo ganador = null;
        double maxValor = Double.MIN_VALUE;

        for (Vehiculo vehiculo : listaDeVehiculos) {
            double valor = vehiculo.velocidad * 0.5 * vehiculo.aceleracion / (vehiculo.anguloDeGiro * (vehiculo.peso - vehiculo.ruedas * 100));
            if (valor > maxValor) {
                maxValor = valor;
                ganador = vehiculo;
            }
        }

        return ganador;
    }

    public void socorrerAuto(String patente) {
        for (Vehiculo vehiculo : listaDeVehiculos) {
            if (vehiculo instanceof Auto && vehiculo.patente.equals(patente)) {
                socorristaAuto.socorrer((Auto) vehiculo);
                break;
            }
        }
    }

    public void socorrerMoto(String patente) {
        for (Vehiculo vehiculo : listaDeVehiculos) {
            if (vehiculo instanceof Moto && vehiculo.patente.equals(patente)) {
                socorristaMoto.socorrer((Moto) vehiculo);
                break;
            }
        }
    }
}

// Clase SocorristaAuto
class SocorristaAuto {
    public void socorrer(Auto unAuto) {
        System.out.println("Socorriendo auto " + unAuto.patente);
    }
}

// Clase SocorristaMoto
class SocorristaMoto {
    public void socorrer(Moto unaMoto) {
        System.out.println("Socorriendo moto " + unaMoto.patente);
    }
}

