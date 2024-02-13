import java.util.ArrayList;
import java.util.List;

public class RepoInscripciones {
    private List<Inscripcion> inscripciones = new ArrayList<>();
    private static RepoInscripciones repoInscripciones;

    public static RepoInscripciones getInstance () {
        if (repoInscripciones == null) repoInscripciones = new RepoInscripciones();
        return repoInscripciones;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }
}
