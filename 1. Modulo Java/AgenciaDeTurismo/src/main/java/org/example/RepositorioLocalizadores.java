package org.example;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositorioLocalizadores {

    // Aca apliqué el patron Singleton --> Una unica instancia global para una clase

    private static RepositorioLocalizadores instance; // Se puede llamar desde cualquier clase
    // haciendo: RepositorioLocalizadores.getInstance() y desde ahi llamar a cualquier metodo sin instanciar la clase.
    private List<Localizador> localizadores = new ArrayList<>();

    private RepositorioLocalizadores () {}

    public List<Localizador> getLocalizadores () {
        return this.localizadores;
    }

    public void addLocalizador (List<Reserva> reservas, Cliente cliente) {
        Localizador l = new Localizador(cliente, reservas);
        this.localizadores.add(l);
    }

    public List<Localizador> getLocalizadorByCliente (Cliente cliente) {
        List<Localizador> localizadoresBuscados = this.localizadores.stream()
                .filter(localizador -> localizador.getCliente().equals(cliente))
                .toList();
        if(localizadoresBuscados.isEmpty()) throw new RuntimeException("No se encontraron localizadores para el cliente: " + cliente.getNombre());
        else return localizadoresBuscados;
    }

    public static RepositorioLocalizadores getInstance() {
        if (instance == null) instance = new RepositorioLocalizadores();
        return instance;
    }

}
