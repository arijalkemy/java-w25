package Covid.dto;

public class DtoInfectados {
    private String nombrePersona;
    private int Edad;
    private String nombreSintoma;

    public DtoInfectados(String nombrePersona, int edad, String nombreSintoma) {
        this.nombrePersona = nombrePersona;
        Edad = edad;
        this.nombreSintoma = nombreSintoma;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public String getNombreSintoma() {
        return nombreSintoma;
    }

    public void setNombreSintoma(String nombreSintoma) {
        this.nombreSintoma = nombreSintoma;
    }
}
