import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaDeInscripciones {

    Integer numInscripciones;
    List<Circuito> circuitos;
    Map<Integer, List<Inscripcion>> inscripcionesEnCircuito;

    public SistemaDeInscripciones(List<Circuito> circuitos){
        numInscripciones = 1;
        this.inscripcionesEnCircuito = new HashMap<>();
        this.circuitos = circuitos;
        for (Circuito c:circuitos) {
            inscripcionesEnCircuito.put(c.getId(), new ArrayList<>());
        }
    }

    public void inscribir(Circuito c, Participante p) {
        verificarCircuitoValido(c);
        verificarParticipanteNoInscripto(p);
        Integer montoAAbonar = c.montoAAbonarPor(p);
        ingresarNuevaInscripcion(c, p, montoAAbonar);
    }

    private void verificarCircuitoValido(Circuito c) {
        if (!circuitoSeEncuentraEnSistema(c)) {
            throw new RuntimeException("El circuito ingresado no es válido");
        }
    }

    private boolean circuitoSeEncuentraEnSistema(Circuito c) {
        return inscripcionesEnCircuito.keySet().contains(c.getId());
    }

    private void ingresarNuevaInscripcion(Circuito c, Participante p, Integer montoAAbonar) {
        Inscripcion nuevaInscripcion = new Inscripcion(numInscripciones, c, p, montoAAbonar);
        numInscripciones++;
        inscripcionesEnCircuito.get(c.getId()).add(nuevaInscripcion);
    }

    public void inscribirEnCircuitoChico(Circuito c, Participante p) {

    }

    private void verificarParticipanteNoInscripto(Participante p) {
        if (participanteSeEncuentraInscripto(p)) {
            throw new RuntimeException("El participante ya se encuentra inscripto en alguna categoria");
        }
    }

    public void mostrarInscriptos() {
        for (Integer id:inscripcionesEnCircuito.keySet()) {
            for (Inscripcion inscripcion:inscripcionesEnCircuito.get(id)) {
                System.out.println(inscripcion);
            }
        }
    }

    public void mostrarInscriptos(Circuito circuito) {
        verificarCircuitoValido(circuito);
        List<Inscripcion> listadoDeInscriptos = inscripcionesEnCircuito.get(circuito.getId());
        for (Inscripcion i:listadoDeInscriptos) {
            System.out.println(i);
        }
    }

    public void desinscribir(Participante p) {
        for (Integer id : inscripcionesEnCircuito.keySet()) {
            List<Inscripcion> inscripcionesActual = inscripcionesEnCircuito.get(id);
            for (int i = 0; i < inscripcionesActual.size(); i++) {
                if (inscripcionesActual.get(i).getParticipante().equals(p)) {
                    inscripcionesActual.remove(i);
                    return;
                }
            }
        }
        throw new RuntimeException("El participante no se encuentra inscripto");
    }

    private boolean participanteSeEncuentraInscripto(Participante p) {
        for (Integer id:inscripcionesEnCircuito.keySet()) {
            for (Inscripcion i:inscripcionesEnCircuito.get(id)) {
                if (i.getParticipante().equals(p)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void mostrarMontosRecaudados() {
        int montoTotal = 0;
        for (Circuito c:circuitos) {
            Integer idCircuito = c.getId();
            int montoActual = obtenerMontoRecaudadoEn(idCircuito);
            System.out.println("El monto recaudado en " + c.getNombre() + " fue de " + montoActual);
            montoTotal+=montoActual;
        }
        System.out.println("En total se recaudó " + montoTotal);
    }

    private Integer obtenerMontoRecaudadoEn(Integer id) {
        int monto = 0;
        for (Inscripcion i:inscripcionesEnCircuito.get(id)) {
            monto+=i.getMontoAAbonar();
        }
        return monto;
    }
}
