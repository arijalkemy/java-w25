package EjercicioDeportistas.dto;

import java.io.Serializable;

public class DtoDeportistas implements Serializable {
    private String nombrePersona;
    private String nombreDeporte;

    public DtoDeportistas(String nombrePersona, String nombreDeporte) {
        this.nombrePersona = nombrePersona;
        this.nombreDeporte = nombreDeporte;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getNombreDeporte() {
        return nombreDeporte;
    }

    public void setNombreDeporte(String nombreDeporte) {
        this.nombreDeporte = nombreDeporte;
    }
}
