package covid;

import covid.Model.Sintoma;

import java.util.List;

public class RepositorioSintoma {
    private List<Sintoma> listaSintomas;

    public RepositorioSintoma(List<Sintoma> listaSintomas) {
        this.listaSintomas = listaSintomas;
    }

    public List<Sintoma> getListaSintomas() {
        return listaSintomas;
    }

    public void setListaSintomas(List<Sintoma> listaSintomas) {
        this.listaSintomas = listaSintomas;
    }
}
