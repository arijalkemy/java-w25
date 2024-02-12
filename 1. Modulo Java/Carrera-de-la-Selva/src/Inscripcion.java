import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Inscripcion {

    static Map<String, Set<Inscripcion>> Inscripciones = new HashMap<>();
    private int numero;
    private Categoria categoria;
    private Participante participante;
    private int monto;

    public Inscripcion(int numero, Categoria categoria, Participante participante) {
        this.numero = numero;
        this.categoria = categoria;
        this.setParticipante(participante);
        this.setMonto();

        if (!Inscripciones.containsKey(categoria.getName())) {
            Inscripciones.put(categoria.getName(), new HashSet<>());
        }

        Inscripciones.get(categoria.getName()).add(this);
    }

    public void anularInscripcion() {
        Inscripciones.get(this.categoria.getName()).remove(this);
    }

    private void setParticipante(Participante participante) {
        participante.setInscripcion(this);
        this.participante = participante;
    }

    private void setMonto() {
        int edadParticipante = this.participante.getEdad();
        switch (this.categoria.getName()) {
            case "chico":
                if (edadParticipante < 18) {
                    this.monto = 1300;
                } else this.monto = 1500;

                break;
            case "medio":
                if (edadParticipante < 18) {
                    this.monto = 2000;
                } else this.monto = 2300;

                break;
            case "avanzado":
                if (edadParticipante < 18) {
                    throw new Error("No se puede inscribir participantes menores de 18 años.");
                } else this.monto = 1500;

                break;
        }
    }

    public int getMonto() {
        return this.monto;
    }
}
